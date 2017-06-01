package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup

class Main11Activity : AppCompatActivity() {

    private var contenedorParticular: View? = null
    private var contenedorCorporativo: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)


        contenedorParticular = findViewById(R.id.ll_contenedor_particular)
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo)

        val opcionesCliente = findViewById(R.id.rg_tipo_cliente) as RadioGroup
        opcionesCliente.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_particular -> mostrarParticular(true)
                R.id.rb_corporativo -> mostrarParticular(false)
            }
        }

        findViewById(R.id.activity_main11).setOnClickListener { startActivity(Intent(this@Main11Activity, Main12Activity::class.java)) }
    }

    private fun mostrarParticular(b: Boolean) {
        contenedorParticular!!.visibility = if (b) View.VISIBLE else View.GONE
        contenedorCorporativo!!.visibility = if (b) View.GONE else View.VISIBLE
    }
}
