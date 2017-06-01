package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        findViewById(R.id.activity_main7).setOnClickListener { startActivity(Intent(this@Main7Activity, Main8Activity::class.java)) }
    }
}
