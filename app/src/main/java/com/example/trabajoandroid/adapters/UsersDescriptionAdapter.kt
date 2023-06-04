package com.example.trabajoandroid.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoandroid.R
import com.example.trabajoandroid.api.ApiRest
import com.example.trabajoandroid.model.User
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class UsersDescriptionAdapter  (private val data: ArrayList<User>,
                    val layoutNuevo2: Int,
                    val onClick: (User) -> Unit
) : RecyclerView.Adapter<UsersDescriptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = LayoutInflater.fro
        // m(parent.context).inflate(R.layout.simple_item, parent, false)
        val view = LayoutInflater.from(parent.context).inflate(layoutNuevo2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

        val elementoCompany = holder.itemView.findViewById<CardView>(R.id.cardCompany)
        elementoCompany.setOnClickListener {
            onClick(data[position])
        }

    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreUser = itemView.findViewById<TextView>(R.id.nombreUser)
        val apellidoUser1 = itemView.findViewById<TextView>(R.id.apellido1User)
        val apellidoUser2 = itemView.findViewById<TextView>(R.id.apellido2User)
        val nombreCompany = itemView.findViewById<TextView>(R.id.nombreCompany)
        val imagenUser = itemView.findViewById<ImageView>(R.id.imgUserCompany)
        val card = itemView.findViewById<CardView>(R.id.cardCompany)

        fun bind(item: User) {
            nombreUser.text = item.firstName
            apellidoUser1.text = item.lastName
            apellidoUser2.text = item.maidenName
            nombreCompany.text = item.company.name
            Picasso.get().load(item.image).into(imagenUser)
        }
    }
}