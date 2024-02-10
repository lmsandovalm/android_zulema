package com.sebastian.laura.model

import android.content.ContentValues
import android.content.Context
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
}