package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val relativeLayout = findViewById(R.id.activity_main5) as RelativeLayout
        relativeLayout.setOnClickListener {
            val intent = Intent(this@Main5Activity, Main6Activity::class.java)
            startActivity(intent)
        }
    }
}
