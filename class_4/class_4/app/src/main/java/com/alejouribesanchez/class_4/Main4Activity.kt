package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val button = findViewById(R.id.boton_iniciar_sesion) as Button
        button.setOnClickListener {
            val intent = Intent(this@Main4Activity, Main5Activity::class.java)
            startActivity(intent)
        }

    }
}
