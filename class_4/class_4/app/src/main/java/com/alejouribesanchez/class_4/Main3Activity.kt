package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val linearLayout = findViewById(R.id.activity_main3) as LinearLayout
        linearLayout.setOnClickListener {
            val intent = Intent(this@Main3Activity, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
