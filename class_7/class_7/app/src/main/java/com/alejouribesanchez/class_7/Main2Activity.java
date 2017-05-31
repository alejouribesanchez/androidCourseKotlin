package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private CheckBox opcionAsegurar;
    private EditText campoMontoGiro;
    private View opcionReporte, opcionZona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        opcionReporte = findViewById(R.id.opcion_reporte);
        opcionZona = findViewById(R.id.opcion_ajuste_local);

        opcionAsegurar = (CheckBox) findViewById(R.id.opcion_asegurar);
        campoMontoGiro = (EditText) findViewById(R.id.campo_monto);

        campoMontoGiro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();

                // Precondición
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }

                float monto = Float.parseFloat(str);

                if (monto >= 2000) {
                    opcionAsegurar.setChecked(true);
                }
            }
        });


        View layout = (View)findViewById(R.id.activity_main2);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });
    }

    public void actualizarCuenta(View view) {
        opcionReporte.setEnabled(true);
        opcionZona.setEnabled(true);

        if(opcionAsegurar.isChecked()){
            startActivity(new Intent(this,Main3Activity.class));
        }

    }


}
