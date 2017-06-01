package com.alejouribesanchez.class_6

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val linearLayout = findViewById(R.id.activity_main2) as LinearLayout
        linearLayout.setOnClickListener { startActivity(Intent(this@Main2Activity, Main3Activity::class.java)) }
    }
}
