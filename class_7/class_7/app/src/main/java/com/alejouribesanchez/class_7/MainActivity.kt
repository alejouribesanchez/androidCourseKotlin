package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var checkBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = findViewById(R.id.seleccion_direccion_envio) as CheckBox

        val button = findViewById(R.id.boton_guardar) as Button
        button.setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }

        findViewById(R.id.activity_main).setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }

    }

    fun loguearCheckbox(v: View) {
        val s = "Estado: " + if (checkBox!!.isChecked) "Marcado" else "No Marcado"
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }


}
