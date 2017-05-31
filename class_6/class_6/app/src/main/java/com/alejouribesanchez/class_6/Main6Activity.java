package com.alejouribesanchez.class_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //Text Watcher
        EditText campoMensaje = (EditText) findViewById(R.id.campo_mensaje);
        campoMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView contador = (TextView) findViewById(R.id.texto_contador);
                String tamanoString = String.valueOf(s.length());
                contador.setText(tamanoString);
            }
        });

        //Text Search
        EditText campoBusqueda = (EditText) findViewById(R.id.campo_busqueda);
        campoBusqueda.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean procesado = false;

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Mostrar mensaje
                    Toast.makeText(Main6Activity.this,
                            "Buscar:" + v.getText().toString(), Toast.LENGTH_LONG).show();

                    // Ocultar teclado virtual
                    InputMethodManager imm =
                            (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    procesado = true;
                }
                return procesado;
            }
        });

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main6);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main6Activity.this, Main7Activity.class));
            }
        });
    }
}
