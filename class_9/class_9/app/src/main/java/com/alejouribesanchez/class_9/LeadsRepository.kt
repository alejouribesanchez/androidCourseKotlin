package com.alejouribesanchez.class_9

import java.util.ArrayList
import java.util.HashMap

/**
 * Created by alejo on 2/23/17.
 */

class LeadsRepository private constructor() {
    private val leads = HashMap<String, Lead>()

    init {
        saveLead(Lead("Alexander Pierrot", "CEO", "Insures S.O.", R.drawable.avatar11))
        saveLead(Lead("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.avatar12))
        saveLead(Lead("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd", R.drawable.avatar13))
        saveLead(Lead("Liliana Clarence", "Diseñadora de Producto", "Creativa App", R.drawable.avatar14))
        saveLead(Lead("Benito Peralta", "Supervisor de Ventas", "Neumáticos Press", R.drawable.avatar15))
        saveLead(Lead("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.avatar16))
        saveLead(Lead("Christian Steps", "CTO", "Cooperativa Verde", R.drawable.avatar17))
        saveLead(Lead("Alexa Giraldo", "Lead Programmer", "Frutisofy", R.drawable.avatar18))
        saveLead(Lead("Linda Murillo", "Directora de Marketing", "Seguros Boliver", R.drawable.avatar19))
        saveLead(Lead("Lizeth Astrada", "CEO", "Concesionario Motolox", R.drawable.avatar100))
    }

    private fun saveLead(lead: Lead) {
        leads.put(lead.id, lead)
    }

    fun getLeads(): List<Lead> {
        return ArrayList(leads.values)
    }

    companion object {
        val instance = LeadsRepository()
    }
}