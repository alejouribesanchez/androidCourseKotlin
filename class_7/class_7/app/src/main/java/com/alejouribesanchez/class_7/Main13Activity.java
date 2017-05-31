package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main13Activity extends AppCompatActivity {

    //Obtener las opciones de respuesta para la pregunta
    // “¿A qué animal nunca dejan de crecerle los dientes?” desde la base de datos

    private ControladorSQLite sqLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        RadioGroup opcionesMarca = (RadioGroup) findViewById(R.id.rg_respuestas);

        sqLiteOpenHelper = new ControladorSQLite(this);

        Cursor c = sqLiteOpenHelper.getRespuestas();

        while (c.moveToNext()) {
            String respuesta = c.getString(c.getColumnIndex(Contrato.ColumnasRespuesta.RESPUESTA));
            opcionesMarca.addView(crearRadioButton(respuesta));
        }

        View layout = (View)findViewById(R.id.activity_main13);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main13Activity.this, Main14Activity.class));
            }
        });

    }

    private RadioButton crearRadioButton(String respuesta) {
        RadioButton nuevoRadio = new RadioButton(this);
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(respuesta);
        nuevoRadio.setTag(respuesta);
        return nuevoRadio;
    }

}

