package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RelativeLayout

class Main4Activity : AppCompatActivity() {

    private var opcionMostrar: CheckBox? = null
    private var campoContrasena: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        opcionMostrar = findViewById(R.id.opcion_mostrar) as CheckBox
        campoContrasena = findViewById(R.id.campo_contrasena) as EditText

        val relativeLayout = findViewById(R.id.activity_main4) as RelativeLayout
        relativeLayout.setOnClickListener { startActivity(Intent(this@Main4Activity, Main5Activity::class.java)) }

        findViewById(R.id.activity_main4).setOnClickListener { startActivity(Intent(this@Main4Activity, Main5Activity::class.java)) }
    }

    fun mostrarContraseña(v: View) {
        // Save cursor
        val cursor = campoContrasena!!.selectionEnd

        if (opcionMostrar!!.isChecked) {
            campoContrasena!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            campoContrasena!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        // Restaurar cursor
        campoContrasena!!.setSelection(cursor)
    }


}
