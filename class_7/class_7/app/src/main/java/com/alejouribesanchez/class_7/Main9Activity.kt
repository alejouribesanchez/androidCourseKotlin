package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class Main9Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        val contenedor = findViewById(R.id.grupo_dias) as RadioGroup
        val opcionI2 = contenedor.getChildAt(2) as RadioButton
        opcionI2.isChecked = true

        contenedor.check(opcionI2.id) //OTRA OPCION

        findViewById(R.id.activity_main9).setOnClickListener { startActivity(Intent(this@Main9Activity, Main10Activity::class.java)) }


    }
}
