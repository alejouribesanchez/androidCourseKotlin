package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Main10Activity extends AppCompatActivity {

    //Mostrar los campos Razón social, Representante y Número de empleados
    // si se selecciona Cliente corporativo. De lo contrario, mostrar los
    // campos para nombre completo y profesión para la opción Particular.

    private View contenedorParticular;
    private View contenedorCorporativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        contenedorParticular = findViewById(R.id.ll_contenedor_particular);
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo);

        View layout = (View)findViewById(R.id.activity_main10);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main10Activity.this, Main11Activity.class));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_corporativo:
                if (marcado) {
                    mostrarParticular(false);
                }
                break;

            case R.id.rb_particular:
                if (marcado) {
                    mostrarParticular(true);
                }
                break;
        }
    }

    private void mostrarParticular(boolean b) {
        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);
    }
}
