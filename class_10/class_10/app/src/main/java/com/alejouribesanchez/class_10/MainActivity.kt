package com.alejouribesanchez.class_10

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Patterns
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private var tilNombre: TextInputLayout? = null
    private var tilTelefono: TextInputLayout? = null
    private var tilCorreo: TextInputLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // Referencias TILs
        tilNombre = findViewById(R.id.til_nombre) as TextInputLayout
        tilTelefono = findViewById(R.id.til_telefono) as TextInputLayout
        tilCorreo = findViewById(R.id.til_correo) as TextInputLayout

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }

        val botonAceptar = findViewById(R.id.boton_aceptar) as Button
        botonAceptar.setOnClickListener { validarDatos() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    /*    Nombre: Solo caracteres alfabéticos con un tamaño máximo de 30.
    Teléfono: Solo caracteres numéricos con un tamaño estándar de 7.
    Email: Secuencia de caracteres que cumplan la sintaxis de correos electrónicos.*/

    private fun validarNombre(nombre: String): Boolean {
        val patron = Pattern.compile("^[a-zA-Z ]+$")
        return patron.matcher(nombre).matches() || nombre.length > 30
    }

    private fun validarTelefono(telefono: String): Boolean {
        return Patterns.PHONE.matcher(telefono).matches()
    }

    private fun validarCorreo(correo: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }


    private fun validarDatos() {
        val nombre = tilNombre!!.editText!!.text.toString()
        val telefono = tilTelefono!!.editText!!.text.toString()
        val correo = tilCorreo!!.editText!!.text.toString()

        val a = validarNombre(nombre)
        val b = validarTelefono(telefono)
        val c = validarCorreo(correo)

        if (a && b && c) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show()

        } else {
            tilNombre!!.error = null
            tilCorreo!!.error = null
            tilTelefono!!.error = null
            if (!a) {
                tilNombre!!.error = "Nombre no Válido"
            }
            if (!b) {
                tilTelefono!!.error = "Telefono no Válido"
            }
            if (!c) {
                tilCorreo!!.error = "Correo no Válido"
            }
        }

    }


}
