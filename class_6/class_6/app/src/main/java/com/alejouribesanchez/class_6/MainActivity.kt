package com.alejouribesanchez.class_6

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById(R.id.editText) as EditText
        val editText1 = findViewById(R.id.editText2) as EditText
        val button = findViewById(R.id.button) as Button
        val button2 = findViewById(R.id.button2) as Button
        button.setOnClickListener {
            val phone = editText.text.toString()
            editText1.setText(phone)
        }

        button2.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editText.windowToken, 0)
        }


        val linearLayout = findViewById(R.id.activity_main) as LinearLayout
        linearLayout.setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }


    }
}
