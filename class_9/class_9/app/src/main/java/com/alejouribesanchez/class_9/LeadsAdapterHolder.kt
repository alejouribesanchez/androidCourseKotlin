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

class LeadsAdapterHolder(context: Context, objects: List<Lead>) : ArrayAdapter<Lead>(context, 0, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Obtener inflater.
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val holder: ViewHolder

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false)

            holder = ViewHolder()
            holder.avatar = convertView!!.findViewById(R.id.iv_avatar) as ImageView
            holder.name = convertView.findViewById(R.id.tv_name) as TextView
            holder.title = convertView.findViewById(R.id.tv_title) as TextView
            holder.company = convertView.findViewById(R.id.tv_company) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }


        // Lead actual.
        val lead = getItem(position)

        // Setup.
        Glide.with(context).load(lead!!.image).into(holder.avatar!!)
        holder.name!!.text = lead.name
        holder.title!!.text = lead.title
        holder.company!!.text = lead.company

        return convertView
    }

    internal class ViewHolder {
        var avatar: ImageView? = null
        var name: TextView? = null
        var title: TextView? = null
        var company: TextView? = null
    }
}