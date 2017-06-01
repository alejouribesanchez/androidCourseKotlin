package com.alejouribesanchez.class_7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class Main12Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        val opcionesMarca = findViewById(R.id.rg_opciones_marca) as RadioGroup

        for (marca in MARCAS) {
            val nuevoRadio = crearRadioButton(marca)
            opcionesMarca.addView(nuevoRadio)
        }

        val primerRadio = opcionesMarca.getChildAt(0) as RadioButton
        primerRadio.isChecked = true

        findViewById(R.id.activity_main12).setOnClickListener { startActivity(Intent(this@Main12Activity, Main13Activity::class.java)) }

    }

    private fun crearRadioButton(marca: String): RadioButton {
        val nuevoRadio = RadioButton(this)
        val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT)
        nuevoRadio.layoutParams = params
        nuevoRadio.text = marca
        nuevoRadio.tag = marca
        return nuevoRadio
    }

    companion object {

        //Crear dinámicamente un conjunto de RadioButtons
        // desde un array de strings cuyo contenido son marcas de autos.

        private val MARCAS = arrayOf("Mazda", "Mercedes Benz", "Audi", "Chevrolet")
    }
}
