package com.example.parcial2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2.Perfil
import com.example.parcial2.R
import com.example.parcial2.models.Opciones

class AdapterOpcion (private val itemList: List<Opciones>, context: Context) : RecyclerView.Adapter<AdapterOpcion.MyViewHolder>(){
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val ivGatito: ImageView = itemView.findViewById(R.id.ivGato)
        val tvG: TextView = itemView.findViewById(R.id.tvGato)
        var id: Int = 0


        init {
            ivGatito.setOnClickListener {
                val intent = Intent(itemView.context, Perfil::class.java)
                Toast.makeText(itemView.context,"Elemento seleccionado: ${id + 1} " + tvG.text, Toast.LENGTH_SHORT).show()

                if (tvG.text=="Perfil"){
                    itemView.context.startActivity(intent)
                }

                if (tvG.text=="Cerrar"){
                    (itemView.context as AppCompatActivity).finish()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_opciones, parent, false)
        val holder = MyViewHolder(itemView)
        itemView.setOnClickListener {
            Toast.makeText(
                parent.context,
                "Has seleccionado el elemento ${holder.id + 1}", // mostramos la posición + 1
                Toast.LENGTH_SHORT
            ).show()
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.id = position
        holder.ivGatito.setImageResource(currentItem.imagen)
        holder.tvG.text = currentItem.texto
    }

    override fun getItemCount() = itemList.size
}