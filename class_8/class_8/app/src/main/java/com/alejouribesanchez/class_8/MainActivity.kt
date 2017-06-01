package com.alejouribesanchez.class_8


import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            //Paso 1: Obtener la instancia del administrador de fragmentos
            val fragmentManager = supportFragmentManager

            //Paso 2: Crear una nueva transacción
            val transaction = fragmentManager.beginTransaction()

            //Paso 3: Crear un nuevo fragmento y añadirlo
            val fragment = BlankFragment()
            transaction.add(R.id.contenedor, fragment)

            //Paso 4: Confirmar el cambio
            transaction.commit()
        }

        val view = findViewById(R.id.activity_main)
        view.setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
