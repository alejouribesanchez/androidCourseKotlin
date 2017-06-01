package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout

class Main8Activity : AppCompatActivity(), View.OnClickListener {

    private var morph: FABToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        morph = findViewById(R.id.fabtoolbar) as FABToolbarLayout

        val uno: View
        val dos: View
        val tres: View
        val cuatro: View
        val button: View

        uno = findViewById(R.id.uno)
        dos = findViewById(R.id.dos)
        cuatro = findViewById(R.id.cuatro)
        tres = findViewById(R.id.tres)
        button = findViewById(R.id.button)

        fab.setOnClickListener(this)
        uno.setOnClickListener(this)
        dos.setOnClickListener(this)
        tres.setOnClickListener(this)
        cuatro.setOnClickListener(this)
        button.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        if (v.id == R.id.fab) {
            morph!!.show()
        } else if (v.id == R.id.button) {
            startActivity(Intent(this@Main8Activity, Main9Activity::class.java))
        }

        morph!!.hide()
    }
}
