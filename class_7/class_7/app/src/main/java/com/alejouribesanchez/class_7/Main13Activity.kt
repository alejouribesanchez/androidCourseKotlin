package com.alejouribesanchez.class_7

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class Main13Activity : AppCompatActivity() {

    //Obtener las opciones de respuesta para la pregunta
    // “¿A qué animal nunca dejan de crecerle los dientes?” desde la base de datos

    private var sqLiteOpenHelper: ControladorSQLite? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        val opcionesMarca = findViewById(R.id.rg_respuestas) as RadioGroup

        sqLiteOpenHelper = ControladorSQLite(this)

        val c = sqLiteOpenHelper!!.respuestas

        while (c.moveToNext()) {
            val respuesta = c.getString(c.getColumnIndex(Contrato.ColumnasRespuesta.RESPUESTA))
            opcionesMarca.addView(crearRadioButton(respuesta))
        }

        findViewById(R.id.activity_main13).setOnClickListener { startActivity(Intent(this@Main13Activity, Main14Activity::class.java)) }

    }

    private fun crearRadioButton(respuesta: String): RadioButton {
        val nuevoRadio = RadioButton(this)
        val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT)
        nuevoRadio.layoutParams = params
        nuevoRadio.text = respuesta
        nuevoRadio.tag = respuesta
        return nuevoRadio
    }

}

