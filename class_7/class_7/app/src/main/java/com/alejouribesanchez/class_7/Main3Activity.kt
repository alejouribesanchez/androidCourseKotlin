package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { startActivity(Intent(this@Main3Activity, Main4Activity::class.java)) }

        findViewById(R.id.activity_main3).setOnClickListener { startActivity(Intent(this@Main3Activity, Main4Activity::class.java)) }
    }
}
