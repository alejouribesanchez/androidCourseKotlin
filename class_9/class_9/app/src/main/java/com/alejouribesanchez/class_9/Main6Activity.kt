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

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.scaleX = 0f
        fab.scaleY = 0f

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val interpolador = AnimationUtils.loadInterpolator(baseContext,
                    android.R.interpolator.fast_out_slow_in)

            fab.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000)
                    .setListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator) {

                        }

                        override fun onAnimationEnd(animation: Animator) {
                            fab.animate()
                                    .scaleY(0f)
                                    .scaleX(0f)
                                    .setInterpolator(interpolador)
                                    .setDuration(600)
                                    .start()
                        }

                        override fun onAnimationCancel(animation: Animator) {

                        }

                        override fun onAnimationRepeat(animation: Animator) {

                        }
                    })
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG).show()
            startActivity(Intent(this@Main6Activity, Main7Activity::class.java))
        }

    }
}
