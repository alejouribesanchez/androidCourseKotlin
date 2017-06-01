package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    internal lateinit var listView: ListView
    internal lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.leads_list) as ListView

        val leadsNames = arrayOf("Alexander Pierrot", "Carlos Lopez", "Sara Bonz", "Liliana Clarence", "Benito Peralta", "Juan Jaramillo", "Christian Steps", "Alexa Giraldo", "Linda Murillo", "Lizeth Astrada")

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, leadsNames)
        listView.adapter = arrayAdapter

        val view = findViewById(R.id.button)
        view.setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }

        val view2 = findViewById(R.id.button2)
        view2.setOnClickListener { listView.divider = null }

    }
}
