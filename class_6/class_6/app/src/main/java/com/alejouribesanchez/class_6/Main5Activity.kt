package com.alejouribesanchez.class_6

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val linearLayout = findViewById(R.id.activity_main5) as LinearLayout
        linearLayout.setOnClickListener { startActivity(Intent(this@Main5Activity, Main6Activity::class.java)) }

        val campo1 = findViewById(R.id.campo_dos_palabras) as EditText
        val texto = campo1.text

        val start = 0
        var end = 0

        for (i in start..texto.length - 1) {

            if (texto[i] == ' ') {
                end = i
            }
        }

        campo1.setSelection(start, end)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { campo1.selectAll() }

    }
}

