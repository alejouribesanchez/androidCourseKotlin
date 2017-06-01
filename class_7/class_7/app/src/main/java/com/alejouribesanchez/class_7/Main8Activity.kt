package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class Main8Activity : AppCompatActivity() {
    private var radioDeposito: RadioButton? = null
    private var grupo: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        radioDeposito = findViewById(R.id.radio_deposito) as RadioButton
        grupo = findViewById(R.id.opciones_pago) as RadioGroup

        findViewById(R.id.activity_main8).setOnClickListener { startActivity(Intent(this@Main8Activity, Main9Activity::class.java)) }

    }

    fun comprobarModoPago(v: View) {
        if (radioDeposito!!.isChecked) {
            val text = "Comprobar ubicación del usuario"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }

    fun comprobarModoPago2(view: View) {
        if (grupo!!.checkedRadioButtonId == R.id.radio_deposito) {
            val text = "Comprobar ubicación del usuario"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }
}
