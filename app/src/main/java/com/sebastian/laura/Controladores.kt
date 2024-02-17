package com.sebastian.laura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import com.sebastian.laura.model.BdManager

class Controladores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controladores)

        val listPeliculas = findViewById<ListView>(R.id.lista_peliculas)
        val bdManager = BdManager(this) //llama concexion de base de datos
        val dataCiudad = bdManager.listData()//almaceno en una variable lo que me trae metodo listData


        listPeliculas.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Buenas peliculas " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }

        val data= arrayOf("Santander", "Popayan", "Bucaramanga")
        val adapterPeliculas = ArrayAdapter(this, android.R.layout.simple_list_item_1,data)
        listPeliculas.adapter=adapterPeliculas

    }
}