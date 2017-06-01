package com.alejouribesanchez.class_5

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Main2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById(R.id.button).setOnClickListener(this)
        findViewById(R.id.button2).setOnClickListener(this)
        findViewById(R.id.button3).setOnClickListener(this)
        findViewById(R.id.button4).setOnClickListener(this)
        findViewById(R.id.button5).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val color: Int
        val contenedor = v.rootView
        when (v.id) {
            R.id.button -> color = Color.parseColor("#80CBC4") // Verde azulado
            R.id.button2 -> color = Color.parseColor("#A5D6A7") // Verde
            R.id.button3 -> color = Color.parseColor("#C5E1A5") // Verde claro
            R.id.button4 -> color = Color.parseColor("#E6EE9C") // Lima
            else -> {startActivity(Intent(this@Main2Activity, Main3Activity::class.java)); color = Color.WHITE } // Blanco
        }
        contenedor.setBackgroundColor(color)
    }
}