package com.sebastian.laura.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
class BdManager(val context : Context) {

    lateinit var bd: SQLiteDatabase
    val bdHelper = BdHelper(context)

    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun insertData(codigo: Int, nombre: String, telefono: Int, direccion: String , cedula: Int, profesion: String, ciudadd: String): Long{
        openBdWr()

        val values = ContentValues()
        values.put("cod", codigo)
        values.put("nombre", nombre)
        values.put("telefono", telefono)
        values.put("direccion", direccion)
        values.put("cedula", cedula)
        values.put("profesion", profesion)
        values.put("ciudad", ciudadd)

        val resul = bd.insert("datos", null,values)
        return resul
    }

    //metodo que retorna un arraylist de tipo ciudad
    fun listData(): ArrayList<Ciudad>{
        val ciudadList=ArrayList<Ciudad>() // Arraylist que retornara el metodo
        openBdRd()//abrir base de datos en modo lectura
        val cursor:Cursor= bd.rawQuery("select *from ciudades", null)

        if (cursor.moveToFirst()) {
            do {
                //recupero la posicion en la que esta la colomna de la tabla
                val idindex = cursor.getColumnIndex("cod")
                val nameIndex = cursor.getColumnIndex("nombre")
                val codigo= cursor.getInt(idindex)
                val nombre = cursor.getString(nameIndex)
                val ciudad = Ciudad(codigo, nombre)
                ciudadList.add(ciudad) //Agrego lo que contiene mi objeto ciudad al array list

                }while (cursor.moveToNext())
            }
        return ciudadList
        }

    }


