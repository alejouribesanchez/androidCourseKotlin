package com.alejouribesanchez.class_3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        this.editText = findViewById(R.id.editText) as EditText

        val sendButton = findViewById(R.id.sendButton) as Button
        sendButton.setOnClickListener {
            val intent = Intent(this@Main2Activity, Main3Activity::class.java)
            val text = editText!!.text.toString()
            intent.putExtra(Main2Activity::class.java!!.getName(), text)
            startActivity(intent)
        }
    }
}
