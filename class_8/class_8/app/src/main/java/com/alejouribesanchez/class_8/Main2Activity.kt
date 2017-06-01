package com.alejouribesanchez.class_8


import android.content.Intent
import android.support.v4.print.PrintHelper
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val view = findViewById(R.id.activity_main2)
        textView = findViewById(R.id.textView) as TextView

        view.setOnClickListener { startActivity(Intent(this@Main2Activity, Main3Activity::class.java)) }

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val actionBar = supportActionBar
            if (actionBar!!.isShowing) {
                actionBar.hide()
            } else {
                actionBar.show()
                //actionBar.setIcon(R.drawable.logo);
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.add -> {
                //metodoAdd()
                textView!!.text = "Se presionó Añadir"
                return true
            }
            R.id.search -> {
                //metodoSearch()
                textView!!.text = "Se presionó Buscar"
                return true
            }
            R.id.edit -> {
                //metodoEdit()
                textView!!.text = "Se presionó Editar"
                return true
            }
            R.id.delete -> {
                //metodoDelete()
                textView!!.text = "Se presionó Eliminar"
                return true
            }
            R.id.action_settings -> {
                //metodoSettings()
                textView!!.text = "Se presionó Ajustes"
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}
