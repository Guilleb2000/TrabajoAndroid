package com.example.trabajoandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoandroid.R
import com.example.trabajoandroid.model.User
import com.squareup.picasso.Picasso

class UserAdapter  (private val data: ArrayList<User>,
                    val layoutNuevo: Int,
                    val onClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false)
        val view = LayoutInflater.from(parent.context).inflate(layoutNuevo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

        val elemento = holder.itemView.findViewById<CardView>(R.id.card)
        elemento.setOnClickListener {
            onClick(data[position])
        }

    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre  = itemView.findViewById<TextView>(R.id.nombre)
        val apellido1 = itemView.findViewById<TextView>(R.id.apellido1)
        val apellido2= itemView.findViewById<TextView>(R.id.apellido2)
        val imagen = itemView.findViewById<ImageView>(R.id.imgUser)
        val card  = itemView.findViewById<CardView>(R.id.card)
        fun bind(item: User) {
            nombre.text = item.firstName
            apellido1.text = item.lastName
            apellido2.text = item.maidenName
            Picasso.get().load(item.image).into(imagen)
        }
    }
}