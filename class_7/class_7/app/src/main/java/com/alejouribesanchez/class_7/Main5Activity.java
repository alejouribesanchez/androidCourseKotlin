package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Main5Activity extends AppCompatActivity {

    private CheckBox opcionOtros;
    private View campoOtros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        opcionOtros = (CheckBox) findViewById(R.id.opcion_otros);
        campoOtros = findViewById(R.id.campo_otros);

        opcionOtros.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                campoOtros.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main5Activity.this, Main6Activity.class));
            }
        });

        View layout = (View)findViewById(R.id.activity_main5);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main5Activity.this, Main6Activity.class));
            }
        });
    }



}
