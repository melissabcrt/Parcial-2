package com.example.parcial2

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2.adapter.AdapterOpcion
import com.example.parcial2.models.FakerOpciones

class MainActivity : AppCompatActivity() {
    private lateinit var tvdatos: TextView
    private lateinit var etDueño: EditText
    private lateinit var etGato: EditText
    private lateinit var etEdad: EditText
    private lateinit var etGuardar: EditText
    private lateinit var bnGuardar: Button
    private val NOMBRE_KEY = "Dueño"
    private val EDAD_KEY = "Gato"
    private val ALTURA_KEY = "Edad"
    private val SWITCH_KEY = "switch_estado"
    private val NOMBRE_INSTANCIA = "nombre_instancia"
    private var nombre: String = ""
    private var edad: String = ""
    private var altura: String = ""
    private var presupuesto: String = ""
    private lateinit var switchPreferencias: SwitchCompat
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menupantalla, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val juegos = FakerOpciones().getOpciones()
        val recycler = findViewById<RecyclerView>(R.id.RecyclerView)
        var administradorDeLayouts = GridLayoutManager(this,2)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = AdapterOpcion(juegos, this)
        Toast.makeText(this, "WIFI", Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val juegos = FakerOpciones().getOpciones()
        val recycler = findViewById<RecyclerView>(R.id.RecyclerView)

        var administradorDeLayouts = GridLayoutManager(this,2)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = AdapterOpcion(juegos, this)


    }

    fun connectToInternet(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }


    private fun inicializarVistas() {
        tvdatos = findViewById(R.id.tvdatos)
        etDueño = findViewById(R.id.etDueño)
        etGato = findViewById(R.id.etGato)
        etEdad = findViewById(R.id.etEdad)
        bnGuardar = findViewById(R.id.bnGuardar)
        switchPreferencias = findViewById(R.id.switchPreferencias)



        bnGuardar.setOnClickListener {
            if(switchPreferencias.isChecked){
                //esta activado
                var nombre = etDueño.text.toString()
                var gato = etGato.text.toString()
                var edad = etEdad.text.toString()
                cambiarTextoBienvenida(nombre,gato)
                val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                val editor = miSharedPreferences.edit()
                editor.putString(NOMBRE_KEY, nombre).apply()
                editor.putString(EDAD_KEY, gato).apply()
                editor.putString(ALTURA_KEY, edad).apply()
            }else{
                Toast.makeText(this, "No guardaste las preferencias", Toast.LENGTH_SHORT).show()
            }
            val i = Intent(this, Perfil::class.java)
            startActivity(i)
        }
    }

    private fun cambiarTextoBienvenida(nombre: String, gato: String) {
        TODO("Not yet implemented")
    }


}