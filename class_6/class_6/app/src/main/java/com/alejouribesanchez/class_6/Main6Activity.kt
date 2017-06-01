package com.alejouribesanchez.class_6

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        //Text Watcher
        val campoMensaje = findViewById(R.id.campo_mensaje) as EditText
        campoMensaje.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val contador = findViewById(R.id.texto_contador) as TextView
                val tamanoString = s.length.toString()
                contador.text = tamanoString
            }
        })

        //Text Search
        val campoBusqueda = findViewById(R.id.campo_busqueda) as EditText
        campoBusqueda.setOnEditorActionListener { v, actionId, event ->
            var procesado = false

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                // Mostrar mensaje
                Toast.makeText(this@Main6Activity,
                        "Buscar:" + v.text.toString(), Toast.LENGTH_LONG).show()

                // Ocultar teclado virtual
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)

                procesado = true
            }
            procesado
        }

        val linearLayout = findViewById(R.id.activity_main6) as LinearLayout
        linearLayout.setOnClickListener { startActivity(Intent(this@Main6Activity, Main7Activity::class.java)) }
    }
}
