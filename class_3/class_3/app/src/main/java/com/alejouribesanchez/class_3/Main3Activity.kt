package com.alejouribesanchez.class_3

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class Main3Activity : AppCompatActivity() {
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        textView = findViewById(R.id.textView) as TextView
        textView!!.text = intent.getStringExtra(Main2Activity::class.java!!.getName())

        val webpage = Uri.parse("http://yuxiglobal.com/")
        val webIntent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(webIntent)

        // Verificar si hay aplicaciones disponibles
        val packageManager = packageManager
        val activities = packageManager.queryIntentActivities(webIntent, 0)
        val isIntentSafe = activities.size > 0
        // Si hay, entonces ejecutamos la actividad
        if (isIntentSafe) {
            Log.d("CLASS_3", activities.size.toString())
        }

        val intent = Intent(this, Main4Activity::class.java)

        val button = findViewById(R.id.button2) as Button
        button.setOnClickListener { startActivityForResult(intent, REQUEST_CODE) }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && requestCode == Activity.RESULT_OK) {
            val result = data.getStringExtra(Main4Activity::class.java!!.getSimpleName())
            textView!!.text = result
        }

    }

    companion object {
        var REQUEST_CODE = 1
    }
}