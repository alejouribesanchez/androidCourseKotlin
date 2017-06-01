package com.alejouribesanchez.class_4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout

class Main8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        val tableLayout = findViewById(R.id.activity_main8) as TableLayout
        tableLayout.setOnClickListener {
            val intent = Intent(this@Main8Activity, Main9Activity::class.java)
            startActivity(intent)
        }
    }
}
