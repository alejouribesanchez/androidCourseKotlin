package com.alejouribesanchez.class_9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

/**
 * Created by alejo on 2/23/17.
 */

class LeadsAdapter(context: Context, objects: List<Lead>) : ArrayAdapter<Lead>(context, 0, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Obtener inflater.
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false)
        }

        // Referencias UI.
        val avatar = convertView!!.findViewById(R.id.iv_avatar) as ImageView
        val name = convertView.findViewById(R.id.tv_name) as TextView
        val title = convertView.findViewById(R.id.tv_title) as TextView
        val company = convertView.findViewById(R.id.tv_company) as TextView

        // Lead actual.
        val lead = getItem(position)

        // Setup.
        Glide.with(context).load(lead!!.image).into(avatar)
        name.text = lead.name
        title.text = lead.title
        company.text = lead.company

        return convertView
    }
}