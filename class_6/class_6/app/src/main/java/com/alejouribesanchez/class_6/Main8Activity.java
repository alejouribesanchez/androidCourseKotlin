package com.alejouribesanchez.class_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Main8Activity extends AppCompatActivity {

    public static String[] SITIOS_MOVIL = {
            "Max Android",
            "Miriado Z",
            "Movil IA",
            "MUX",
            "Masterd en Android",
            "Minimum IOs Shippable",
            "Melody Movil"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        AutoCompleteTextView campoSugerencias = (AutoCompleteTextView) findViewById(R.id.campo_sugerencias);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, SITIOS_MOVIL);
        campoSugerencias.setAdapter(adaptador);
    }

}
