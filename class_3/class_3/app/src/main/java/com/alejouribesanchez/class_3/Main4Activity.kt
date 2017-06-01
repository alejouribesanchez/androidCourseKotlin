package com.alejouribesanchez.class_3

import android.app.Activity
import android.content.Intent
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val radioGroup = findViewById(R.id.group_radiobutton) as RadioGroup
        val button = findViewById(R.id.button3) as Button
        button.setOnClickListener {
            val idRadio = radioGroup.checkedRadioButtonId
            val opt: String
            when (idRadio) {
                R.id.radio1 -> opt = "option1"
                R.id.radio2 -> opt = "option2"
                R.id.radio3 -> opt = "option3"
                R.id.radio4 -> opt = "option4"
                else -> opt = "option1"
            }

            val dataBack = Intent()
            val name = Main4Activity::class.java!!.getSimpleName()
            dataBack.putExtra(name, opt)
            setResult(Activity.RESULT_OK, dataBack)
            finish()
        }

    }
}
