package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val relativeLayout = findViewById(R.id.rl_activity6) as RelativeLayout
        relativeLayout.setOnClickListener {
            val intent = Intent(this@Main6Activity, Main7Activity::class.java)
            startActivity(intent)
        }
    }
}
