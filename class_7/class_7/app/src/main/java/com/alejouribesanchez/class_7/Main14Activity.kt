package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main14Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)

        findViewById(R.id.activity_main14).setOnClickListener {
            //startActivity(new Intent(Main14Activity.this, Main15Activity.class));
        }
    }
}
