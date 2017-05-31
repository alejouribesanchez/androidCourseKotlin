package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main12Activity extends AppCompatActivity {

    //Crear dinámicamente un conjunto de RadioButtons
    // desde un array de strings cuyo contenido son marcas de autos.

    private static String[] MARCAS = {
            "Mazda", "Mercedes Benz", "Audi", "Chevrolet"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        RadioGroup opcionesMarca = (RadioGroup)findViewById(R.id.rg_opciones_marca);

        for(String marca : MARCAS) {
            RadioButton nuevoRadio = crearRadioButton(marca);
            opcionesMarca.addView(nuevoRadio);
        }

        RadioButton primerRadio = (RadioButton) opcionesMarca.getChildAt(0);
        primerRadio.setChecked(true);

        View layout = (View)findViewById(R.id.activity_main12);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main12Activity.this, Main13Activity.class));
            }
        });

    }

    private RadioButton crearRadioButton(String marca) {
        RadioButton nuevoRadio = new RadioButton(this);
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(marca);
        nuevoRadio.setTag(marca);
        return nuevoRadio;
    }
}
