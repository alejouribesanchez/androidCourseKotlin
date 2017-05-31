package com.alejouribesanchez.class_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        RadioGroup contenedor = (RadioGroup) findViewById(R.id.grupo_dias);
        RadioButton opcionI2 = (RadioButton) contenedor.getChildAt(2);
        opcionI2.setChecked(true);

        contenedor.check(opcionI2.getId()); //OTRA OPCION

        View layout = (View)findViewById(R.id.activity_main9);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main9Activity.this, Main10Activity.class));
            }
        });


    }
}
