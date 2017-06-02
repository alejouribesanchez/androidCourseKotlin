package com.gapps.class_12

/**
 * Created by alejo on 6/2/17.
 */

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.text.SimpleDateFormat
import java.util.Calendar


class FullScreenDialog : DialogFragment() {

    private var textFecha: TextView? = null
    private var textTiempo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // Obtener instancia de la action bar
        val actionBar = (activity as AppCompatActivity)
                .supportActionBar

        if (actionBar != null) {
            // Habilitar el Up Button
            actionBar.setDisplayHomeAsUpEnabled(true)
            // Cambiar icono del Up Button
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fullscreen_dialog, container, false)
        iniciarHora(view)// Setear hora inicial
        iniciarFecha(view)// Setear fecha inicial
        return view
    }

    private fun iniciarHora(view: View) {
        textTiempo = view.findViewById(R.id.hora_text) as TextView
        val c = Calendar.getInstance()
        val format = SimpleDateFormat("HH:mm a")
        textTiempo!!.text = format.format(c.time)

        textTiempo!!.setOnClickListener { TimeDialog().show(fragmentManager, "TimePickerInFull") }
    }

    private fun iniciarFecha(view: View) {
        textFecha = view.findViewById(R.id.fecha_text) as TextView
        val c = Calendar.getInstance()
        val format = SimpleDateFormat("E MMM d yyyy")
        textFecha!!.text = format.format(c.time)

        textFecha!!.setOnClickListener { DateDialog().show(fragmentManager, "DatePickerInFull") }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.fullscreen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        when (id) {
            android.R.id.home -> {
            }
            R.id.action_save -> {
            }
        }// procesarDescartar()
        // procesarGuardar()

        return super.onOptionsItemSelected(item)
    }

    /**
     * Actualiza la fecha del view `fecha_text`
     * @param year Nuevo Año
     * *
     * @param monthOfYear Nuevo Mes
     * *
     * @param dayOfMonth Nuevo día
     */
    fun setDateView(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val c = Calendar.getInstance()
        c.set(year, monthOfYear, dayOfMonth)
        val format = SimpleDateFormat("E MMM d yyyy")
        textFecha!!.text = format.format(c.time)
    }

    /**
     * Actualiza la hora del view `hora_text`
     * @param hourOfDay Nueva Hora
     * *
     * @param minute Nuevos Minutos
     */
    fun setTimeView(hourOfDay: Int, minute: Int) {
        val c = Calendar.getInstance()
        c.set(Calendar.HOUR, hourOfDay)
        c.set(Calendar.MINUTE, minute)
        val format = SimpleDateFormat("HH:mm a")
        textTiempo!!.text = format.format(c.time)
    }
}// Required empty public constructor
