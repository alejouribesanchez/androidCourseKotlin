package com.alejouribesanchez.class_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alejo on 2/23/17.
 */

public class LeadsRepository {
    private static LeadsRepository repository = new LeadsRepository();
    private HashMap<String, Lead> leads = new HashMap<>();

    public static LeadsRepository getInstance() {
        return repository;
    }

    private LeadsRepository() {
        saveLead(new Lead("Alexander Pierrot", "CEO", "Insures S.O.", R.drawable.avatar11));
        saveLead(new Lead("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.avatar12));
        saveLead(new Lead("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd", R.drawable.avatar13));
        saveLead(new Lead("Liliana Clarence", "Diseñadora de Producto", "Creativa App", R.drawable.avatar14));
        saveLead(new Lead("Benito Peralta", "Supervisor de Ventas", "Neumáticos Press", R.drawable.avatar15));
        saveLead(new Lead("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.avatar16));
        saveLead(new Lead("Christian Steps", "CTO", "Cooperativa Verde", R.drawable.avatar17));
        saveLead(new Lead("Alexa Giraldo", "Lead Programmer", "Frutisofy", R.drawable.avatar18));
        saveLead(new Lead("Linda Murillo", "Directora de Marketing", "Seguros Boliver", R.drawable.avatar19));
        saveLead(new Lead("Lizeth Astrada", "CEO", "Concesionario Motolox", R.drawable.avatar100));
    }

    private void saveLead(Lead lead) {
        leads.put(lead.getId(), lead);
    }

    public List<Lead> getLeads() {
        return new ArrayList<>(leads.values());
    }
}