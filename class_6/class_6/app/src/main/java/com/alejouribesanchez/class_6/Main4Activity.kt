package com.alejouribesanchez.class_6

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val campo1 = findViewById(R.id.campo_cursor) as EditText
        campo1.setSelection(3)

        val editText = findViewById(R.id.campo_1) as EditText


        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { editText.setText(campo1.selectionEnd.toString()) }

        val linearLayout = findViewById(R.id.activity_main4) as LinearLayout
        linearLayout.setOnClickListener { startActivity(Intent(this@Main4Activity, Main5Activity::class.java)) }

    }
}
