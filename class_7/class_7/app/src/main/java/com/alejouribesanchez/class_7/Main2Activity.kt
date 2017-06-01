package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class Main2Activity : AppCompatActivity() {

    private var opcionAsegurar: CheckBox? = null
    private var campoMontoGiro: EditText? = null
    private var opcionReporte: View? = null
    private var opcionZona: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        opcionReporte = findViewById(R.id.opcion_reporte)
        opcionZona = findViewById(R.id.opcion_ajuste_local)

        opcionAsegurar = findViewById(R.id.opcion_asegurar) as CheckBox
        campoMontoGiro = findViewById(R.id.campo_monto) as EditText

        campoMontoGiro!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                var str = s.toString()

                // Precondición
                if (TextUtils.isEmpty(str)) {
                    str = "0"
                }

                val monto = java.lang.Float.parseFloat(str)

                if (monto >= 2000) {
                    opcionAsegurar!!.isChecked = true
                }
            }
        })


        findViewById(R.id.activity_main2).setOnClickListener { startActivity(Intent(this@Main2Activity, Main3Activity::class.java)) }
    }

    fun actualizarCuenta(view: View) {
        opcionReporte!!.isEnabled = true
        opcionZona!!.isEnabled = true

        if (opcionAsegurar!!.isChecked) {
            startActivity(Intent(this, Main3Activity::class.java))
        }

    }


}
