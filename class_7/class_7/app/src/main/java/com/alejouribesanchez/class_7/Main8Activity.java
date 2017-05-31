package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    private RadioButton radioDeposito;
    private RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        radioDeposito = (RadioButton) findViewById(R.id.radio_deposito);
        grupo = (RadioGroup) findViewById(R.id.opciones_pago);

        View layout = (View)findViewById(R.id.activity_main8);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main8Activity.this, Main9Activity.class));
            }
        });

    }

    public void comprobarModoPago(View v){
        if (radioDeposito.isChecked()){
            final String text = "Comprobar ubicación del usuario";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }

    public void comprobarModoPago2(View view) {
        if (grupo.getCheckedRadioButtonId() == R.id.radio_deposito) {
            final String text = "Comprobar ubicación del usuario";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
