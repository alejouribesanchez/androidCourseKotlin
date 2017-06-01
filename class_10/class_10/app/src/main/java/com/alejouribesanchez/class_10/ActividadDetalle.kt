package com.alejouribesanchez.class_10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView

import com.bumptech.glide.Glide

class ActividadDetalle : AppCompatActivity() {
    private var itemDetallado: Coche? = null
    private var imagenExtendida: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_detalle)

        usarToolbar()

        // Obtener el coche con el identificador establecido en la actividad principal
        itemDetallado = Coche.getItem(intent.getIntExtra(EXTRA_PARAM_ID, 0))

        imagenExtendida = findViewById(R.id.imagen_extendida) as ImageView

        cargarImagenExtendida()
    }

    private fun cargarImagenExtendida() {
        Glide.with(imagenExtendida!!.context)
                .load(itemDetallado!!.idDrawable)
                .into(imagenExtendida!!)
    }

    private fun usarToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    companion object {

        val EXTRA_PARAM_ID = "coches2015.extra.ID"
        val VIEW_NAME_HEADER_IMAGE = "imagen_compartida"
    }
}
