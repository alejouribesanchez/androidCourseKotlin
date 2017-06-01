package com.alejouribesanchez.class_7

/**
 * Created by alejo on 2/21/17.
 */

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

/**
 * Controlador de operaciones de la base de datos
 */
class ControladorSQLite(private val contexto: Context) : SQLiteOpenHelper(contexto, ControladorSQLite.NOMBRE_BASE_DATOS, null, ControladorSQLite.VERSION_ACTUAL) {

    internal interface Tablas {
        companion object {
            val RESPUESTA = "respuesta" //NOMBRE DE LA TABLA
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        val respuesta = Contrato.ColumnasRespuesta.RESPUESTA

        val scriptCreate = "CREATE TABLE " + Tablas.RESPUESTA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                respuesta + " TEXT UNIQUE NOT NULL)"
        db.execSQL(scriptCreate)

        val cv = ContentValues()
        cv.put(respuesta, "A. Castor")
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv)
        cv.put(respuesta, "B. Jaguar")
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv)
        cv.put(respuesta, "C. Elefante")
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv)
        cv.put(respuesta, "D. Rinoceronte")
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.RESPUESTA)
        onCreate(db)
    }

    val respuestas: Cursor
        get() {
            val db = readableDatabase
            return db.query(Tablas.RESPUESTA, null, null, null, null, null, null)
        }

    companion object {

        private val NOMBRE_BASE_DATOS = "preguntas.db"

        private val VERSION_ACTUAL = 1
    }
}