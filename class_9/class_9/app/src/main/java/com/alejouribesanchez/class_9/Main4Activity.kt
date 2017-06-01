package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val view = findViewById(R.id.activity_main4)
        view.setOnClickListener { startActivity(Intent(this@Main4Activity, Main5Activity::class.java)) }
    }
}
