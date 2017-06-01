package com.alejouribesanchez.class_6

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView

class Main7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val editUsername = findViewById(R.id.username) as EditText

        editUsername.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            // ¿v tiene el foco?
            if (hasFocus) {
                val iconoDescuento = findViewById(R.id.ic_account) as ImageView
                var d = iconoDescuento.drawable

                d = DrawableCompat.wrap(d)
                DrawableCompat.setTint(d,
                        ContextCompat.getColor(this@Main7Activity, R.color.colorAccent))

            }
        }
    }

}
