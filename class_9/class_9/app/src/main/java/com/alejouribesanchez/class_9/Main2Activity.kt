package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    internal lateinit var listView: ListView
    internal lateinit var adapter: LeadsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        listView = findViewById(R.id.leads_list) as ListView
        adapter = LeadsAdapter(this, LeadsRepository.instance.getLeads())

        //Relacionando la lista con el adaptador
        listView.adapter = adapter

        findViewById(R.id.button).setOnClickListener { startActivity(Intent(this@Main2Activity, Main3Activity::class.java)) }


        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val tempLead = adapterView.getItemAtPosition(i) as Lead
            Toast.makeText(applicationContext, "Iniciar screen de detalle para: \n" + tempLead.name,
                    Toast.LENGTH_SHORT).show()
        }

    }
}
