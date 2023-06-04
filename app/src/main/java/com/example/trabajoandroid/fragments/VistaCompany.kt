package com.example.trabajoandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.trabajoandroid.R
import com.example.trabajoandroid.adapters.UserAdapter
import com.example.trabajoandroid.adapters.UsersDescriptionAdapter
import com.example.trabajoandroid.api.ApiRest
import com.example.trabajoandroid.model.User
import com.example.trabajoandroid.model.Users
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VistaCompany : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vista_company, container, false)
    }

    private lateinit var rvCompany: RecyclerView
    val TAG = "VistaCompany"
    var data: ArrayList<User> = ArrayList()
    private var adapter: UsersDescriptionAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCompany = view.findViewById<RecyclerView>(R.id.rvCompany)

        val mLayoutManager = GridLayoutManager(this.context, 1)
        rvCompany.layoutManager = mLayoutManager

        adapter = UsersDescriptionAdapter(data, R.layout.simple_item_company) {

            val fragment = VistaCompany()
            val bundle = Bundle()
            bundle.putSerializable("miCompany", it)
            fragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.mainContainer, fragment)?.addToBackStack("VistaUsers")?.commit()
        }

        rvCompany.adapter = adapter
        ApiRest.initService()
        getCompany()
    }

    private fun getCompany() {
        val call = ApiRest.service.getUsers()
        call.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    Log.i(TAG, body.toString())
                    data.clear()
                    data.addAll(body.users)
                    Log.i(TAG, data.toString())
                    adapter?.notifyItemRangeChanged(0, data.size)
                } else {
                    Log.e(TAG, response.errorBody()?.string() ?: "error")
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }
}
