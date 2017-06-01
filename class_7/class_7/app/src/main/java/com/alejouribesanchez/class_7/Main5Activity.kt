package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class Main5Activity : AppCompatActivity() {

    private var opcionOtros: CheckBox? = null
    private var campoOtros: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        opcionOtros = findViewById(R.id.opcion_otros) as CheckBox
        campoOtros = findViewById(R.id.campo_otros)

        opcionOtros!!.setOnCheckedChangeListener { buttonView, isChecked -> campoOtros!!.visibility = if (isChecked) View.VISIBLE else View.GONE }

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { startActivity(Intent(this@Main5Activity, Main6Activity::class.java)) }

        findViewById(R.id.activity_main5).setOnClickListener { startActivity(Intent(this@Main5Activity, Main6Activity::class.java)) }
    }


}
