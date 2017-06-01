package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton

class Main10Activity : AppCompatActivity() {

    //Mostrar los campos Razón social, Representante y Número de empleados
    // si se selecciona Cliente corporativo. De lo contrario, mostrar los
    // campos para nombre completo y profesión para la opción Particular.

    private var contenedorParticular: View? = null
    private var contenedorCorporativo: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        contenedorParticular = findViewById(R.id.ll_contenedor_particular)
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo)

        findViewById(R.id.activity_main10).setOnClickListener { startActivity(Intent(this@Main10Activity, Main11Activity::class.java)) }
    }

    fun onRadioButtonClicked(view: View) {
        val marcado = (view as RadioButton).isChecked

        when (view.getId()) {
            R.id.rb_corporativo -> if (marcado) {
                mostrarParticular(false)
            }

            R.id.rb_particular -> if (marcado) {
                mostrarParticular(true)
            }
        }
    }

    private fun mostrarParticular(b: Boolean) {
        contenedorParticular!!.visibility = if (b) View.VISIBLE else View.GONE
        contenedorCorporativo!!.visibility = if (b) View.GONE else View.VISIBLE
    }
}
