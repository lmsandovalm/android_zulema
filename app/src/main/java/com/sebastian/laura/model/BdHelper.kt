package com.sebastian.laura.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper(
    context: Context?,

) : SQLiteOpenHelper(context, Constants.NOM_BD, null, Constants.VERSION_BD) {
    override fun onCreate(db: SQLiteDatabase?) {

        //db?.execSQL(Constants.TABLA)
        db?.execSQL(Constants.Datos)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTs ciudades")
        db?.execSQL("DROP TABLE IF EXISTs datos")
        onCreate(db)
    }
}