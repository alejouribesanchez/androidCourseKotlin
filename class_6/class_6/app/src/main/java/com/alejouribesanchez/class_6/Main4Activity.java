package com.alejouribesanchez.class_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final EditText campo1 = (EditText) findViewById(R.id.campo_cursor);
        campo1.setSelection(3);

        final EditText editText = (EditText)findViewById(R.id.campo_1);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText(String.valueOf(campo1.getSelectionEnd()));

            }
        });

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main4);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main4Activity.this, Main5Activity.class));
            }
        });

    }
}
