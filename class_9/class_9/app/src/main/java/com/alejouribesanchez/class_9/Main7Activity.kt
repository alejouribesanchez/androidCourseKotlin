package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator

class Main7Activity : AppCompatActivity() {

    internal var click = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setImageResource(R.drawable.avatar11)

        fab.setOnClickListener { view ->
            click = !click
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                val interpolador = AnimationUtils.loadInterpolator(baseContext,
                        android.R.interpolator.fast_out_slow_in)

                view.animate()
                        .rotation(if (click) 180f else 0f)
                        .setInterpolator(interpolador)
                        .start()
            }
        }

        val view = findViewById(R.id.button)
        view.setOnClickListener { startActivity(Intent(this@Main7Activity, Main8Activity::class.java)) }
    }
}
