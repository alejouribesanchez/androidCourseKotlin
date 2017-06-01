package com.alejouribesanchez.class_9

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class Main3Activity : AppCompatActivity() {

    internal lateinit var listView: ListView
    internal lateinit var adapter: LeadsAdapterHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        listView = findViewById(R.id.leads_list) as ListView
        adapter = LeadsAdapterHolder(this, LeadsRepository.instance.getLeads())

        //Relacionando la lista con el adaptador
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val tempLead = adapterView.getItemAtPosition(i) as Lead
            Toast.makeText(applicationContext, "Iniciar screen de detalle para: \n" + tempLead.name,
                    Toast.LENGTH_SHORT).show()
        }

        findViewById(R.id.button).setOnClickListener { startActivity(Intent(this@Main3Activity, Main4Activity::class.java)) }

    }
}
