package com.example.parcial2.models

import com.example.parcial2.R

class FakerOpciones {
    fun getOpciones() : ArrayList<Opciones>{
        val opciones : ArrayList<Opciones>
        opciones = arrayListOf<Opciones>()

        val opcion = Opciones(1, R.drawable.cat,"Gatos")
        opciones.add(opcion)
        opciones.add(Opciones(2,R.drawable.profile,"Perfil"))
        opciones.add(Opciones(3,R.drawable.config,"Configurar"))
        opciones.add(Opciones(4,R.drawable.close,"Cerrar"))
        return opciones
    }
}