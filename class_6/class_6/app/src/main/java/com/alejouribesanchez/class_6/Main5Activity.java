package com.alejouribesanchez.class_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main5);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main5Activity.this, Main6Activity.class));
            }
        });

        final EditText campo1 = (EditText) findViewById(R.id.campo_dos_palabras);
        Editable texto = campo1.getText();

        int start = 0;
        int end = 0;

        for (int i = start; i < texto.length(); i++) {

            if (texto.charAt(i) == ' ') {
                end = i;
            }
        }

        campo1.setSelection(start, end);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                campo1.selectAll();

            }
        });

    }
}

