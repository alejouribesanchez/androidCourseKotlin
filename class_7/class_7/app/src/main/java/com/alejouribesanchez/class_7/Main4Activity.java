package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Main4Activity extends AppCompatActivity {

    private CheckBox opcionMostrar;
    private EditText campoContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        opcionMostrar = (CheckBox)findViewById(R.id.opcion_mostrar);
        campoContrasena = (EditText)findViewById(R.id.campo_contrasena);

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_main4);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main4Activity.this, Main5Activity.class));
            }
        });

        View layout = (View)findViewById(R.id.activity_main4);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main4Activity.this, Main5Activity.class));
            }
        });
    }

    public void mostrarContraseña(View v){
        // Save cursor
        int cursor = campoContrasena.getSelectionEnd();

        if(opcionMostrar.isChecked()){
            campoContrasena.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            campoContrasena.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        // Restaurar cursor
        campoContrasena.setSelection(cursor);
    }


}
