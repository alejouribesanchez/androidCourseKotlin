package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Main11Activity extends AppCompatActivity {

    private View contenedorParticular;
    private View contenedorCorporativo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);


        contenedorParticular = findViewById(R.id.ll_contenedor_particular);
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo);

        RadioGroup opcionesCliente = (RadioGroup)findViewById(R.id.rg_tipo_cliente);
        opcionesCliente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_particular:
                        mostrarParticular(true);
                        break;
                    case R.id.rb_corporativo:
                        mostrarParticular(false);
                        break;
                }
            }
        });

        View layout = (View)findViewById(R.id.activity_main11);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main11Activity.this, Main12Activity.class));
            }
        });
    }

    private void mostrarParticular(boolean b) {
        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);
    }
}
