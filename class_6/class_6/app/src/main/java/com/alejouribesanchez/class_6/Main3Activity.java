package com.alejouribesanchez.class_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        if (findViewById(R.id.campo_1).isFocusable()) {
            findViewById(R.id.campo_2).requestFocus();
        }

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main3);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this, Main4Activity.class));
            }
        });

    }
}
