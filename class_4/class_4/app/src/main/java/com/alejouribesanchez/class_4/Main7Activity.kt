package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TableLayout

class Main7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val tableLayout = findViewById(R.id.activity_main7) as TableLayout
        tableLayout.setOnClickListener {
            val intent = Intent(this@Main7Activity, Main8Activity::class.java)
            startActivity(intent)
        }
    }
}
