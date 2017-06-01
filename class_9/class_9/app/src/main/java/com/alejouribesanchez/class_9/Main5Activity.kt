package com.alejouribesanchez.class_9

import android.animation.Animator
import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { startActivity(Intent(this@Main5Activity, Main6Activity::class.java)) }
    }

}
