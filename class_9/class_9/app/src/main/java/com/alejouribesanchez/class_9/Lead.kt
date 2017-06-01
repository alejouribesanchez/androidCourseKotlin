package com.alejouribesanchez.class_9

import java.util.UUID

/**
 * Created by alejo on 2/23/17.
 */

class Lead(var name: String?, var title: String?, var company: String?, var image: Int) {
    var id: String = ""

    init {
        id = UUID.randomUUID().toString()
    }

    override fun toString(): String {
        return "Lead{" +
                "ID='" + id + '\'' +
                ", Compañía='" + company + '\'' +
                ", Nombre='" + name + '\'' +
                ", Cargo='" + title + '\'' +
                '}'
    }
}
