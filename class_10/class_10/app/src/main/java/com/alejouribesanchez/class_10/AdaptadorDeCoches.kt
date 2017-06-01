package com.alejouribesanchez.class_10

/**
 * Created by alejo on 2/28/17.
 */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

/**
 * [BaseAdapter] para poblar coches en un grid view
 */

class AdaptadorDeCoches(private val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return Coche.ITEMS.size
    }

    override fun getItem(position: Int): Coche {
        return Coche.ITEMS[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view

        if (view == null) {
            val inflater = context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.grid_item, viewGroup, false)
        }

        val imagenCoche = view!!.findViewById(R.id.imagen_coche) as ImageView
        val nombreCoche = view.findViewById(R.id.nombre_coche) as TextView


        /*
        final Coche item = getItem(position);
        imagenCoche.setImageResource(item.getIdDrawable()); */ //SIN GLIDE

        val item = getItem(position)
        Glide.with(imagenCoche.context)
                .load(item.idDrawable)
                .into(imagenCoche)

        nombreCoche.text = item.nombre

        return view
    }

}