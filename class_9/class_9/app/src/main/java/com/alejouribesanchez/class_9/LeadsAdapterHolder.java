package com.alejouribesanchez.class_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by alejo on 2/23/17.
 */

public class LeadsAdapterHolder extends ArrayAdapter<Lead> {
    public LeadsAdapterHolder(Context context, List<Lead> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false);

            holder = new ViewHolder();
            holder.avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.company = (TextView) convertView.findViewById(R.id.tv_company);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }



        // Lead actual.
        Lead lead = getItem(position);

        // Setup.
        Glide.with(getContext()).load(lead.getImage()).into(holder.avatar);
        holder.name.setText(lead.getName());
        holder.title.setText(lead.getTitle());
        holder.company.setText(lead.getCompany());

        return convertView;
    }

    static class ViewHolder {
        ImageView avatar;
        TextView name;
        TextView title;
        TextView company;
    }
}