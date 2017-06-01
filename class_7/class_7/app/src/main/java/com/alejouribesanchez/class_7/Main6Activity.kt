package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val seccionIndustria = findViewById(R.id.activity_main6) as LinearLayout

        for (industria in INDUSTRIAS) {
            val opcion = CheckBox(this)
            opcion.text = industria
            opcion.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            seccionIndustria.addView(opcion)
        }

        findViewById(R.id.activity_main6).setOnClickListener { startActivity(Intent(this@Main6Activity, Main7Activity::class.java)) }
    }

    companion object {

        var INDUSTRIAS = arrayOf("Arte", "Computación", "Ingeniería civil", "Bioquímica", "Música", "Astronomía", "Zoología")
    }
}
