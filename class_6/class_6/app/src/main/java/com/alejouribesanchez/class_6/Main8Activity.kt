package com.alejouribesanchez.class_6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class Main8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        val campoSugerencias = findViewById(R.id.campo_sugerencias) as AutoCompleteTextView

        val adaptador = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, SITIOS_MOVIL)
        campoSugerencias.setAdapter(adaptador)
    }

    companion object {

        var SITIOS_MOVIL = arrayOf("Max Android", "Miriado Z", "Movil IA", "MUX", "Masterd en Android", "Minimum IOs Shippable", "Melody Movil")
    }

}
