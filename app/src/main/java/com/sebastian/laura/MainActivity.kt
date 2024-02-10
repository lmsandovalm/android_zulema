package com.sebastian.laura

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sebastian.laura.model.BdHelper
import com.sebastian.laura.model.BdManager

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editcodigo = findViewById<EditText>(R.id.et_codigo)
        val editnombre = findViewById<EditText>(R.id.et_nombre)
        val edittel = findViewById<EditText>(R.id.et_telefono)
        val editdirec = findViewById<EditText>(R.id.et_direccion)
        val editcedula = findViewById<EditText>(R.id.et_cedula)
        val editprofesion = findViewById<EditText>(R.id.et_profesion)
        val editciudad = findViewById<EditText>(R.id.et_ciudad)
        val btninsertar = findViewById<Button>(R.id.btn_insertar)

        btninsertar.setOnClickListener {
            val codigo = editcodigo.text.toString()
            val nombre = editnombre.text.toString()
            val telefono = edittel.text.toString()
            val direccion = editdirec.text.toString()
            val cedula = editcedula.text.toString()
            val profesion = editprofesion.text.toString()
            val ciudadd = editciudad.text.toString()

            val  managerDb = BdManager(this)
            val resul = managerDb.insertData(codigo.toInt(), nombre, telefono.toInt(), direccion, cedula.toInt(), profesion, ciudadd)

            if (resul>0){
                Toast.makeText(this, "Datos Insertados" + resul, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ha ocurrido un problema" + resul, Toast.LENGTH_SHORT).show()
            }

        }

    }
}