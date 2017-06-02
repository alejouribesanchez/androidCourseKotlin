package com.gapps.class_12

import android.app.DatePickerDialog
import android.app.Fragment
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast

import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener, SimpleDialog.OnSimpleDialogListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView) as TextView
        val button = findViewById(R.id.button) as Button
        val button2 = findViewById(R.id.button2) as Button
        val button3 = findViewById(R.id.button3) as Button
        val button4 = findViewById(R.id.button4) as Button
        val button5 = findViewById(R.id.button5) as Button
        val button6 = findViewById(R.id.button6) as Button
        val button7 = findViewById(R.id.button7) as Button
        val button8 = findViewById(R.id.button8) as Button
        val button9 = findViewById(R.id.button9) as Button
        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    fun creatSimpleAlertDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Title Alert")
                .setMessage("Message for user")
                .setPositiveButton("OK"
                ) { dialog, which -> textView!!.text = "OK" }
                .setNegativeButton("CANCEL"
                ) { dialog, which -> textView!!.text = "CANCEL" }

        return builder.create()

    }

    fun createSingleListDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)

        val items = arrayOfNulls<CharSequence>(3)

        items[0] = "Orange"
        items[1] = "Mango"
        items[2] = "Banana"

        builder.setTitle("List Dialog")
                .setItems(items) { dialog, which ->
                    Toast.makeText(
                            this@MainActivity,
                            "Selected:" + items[which],
                            Toast.LENGTH_SHORT)
                            .show()
                }

        return builder.create()
    }

    fun createRadioListDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        val items = arrayOfNulls<CharSequence>(3)
        items[0] = "Single"
        items[1] = "Married"
        items[2] = "Divorced"
        builder.setTitle("Civil state")
                .setSingleChoiceItems(items, 0) { dialog, which ->
                    Toast.makeText(
                            this@MainActivity,
                            "Selected: " + items[which],
                            Toast.LENGTH_SHORT)
                            .show()
                }
        return builder.create()
    }

    fun createMultipleListDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)

        val itemsSeleccionados = ArrayList<Int>()

        val items = arrayOfNulls<CharSequence>(3)

        items[0] = "Android Development"
        items[1] = "iOS Development"
        items[2] = "Mobile Development"

        builder.setTitle("Interesting")
                .setMultiChoiceItems(items, null) { dialog, which, isChecked ->
                    if (isChecked) {
                        // Guardar indice seleccionado
                        itemsSeleccionados.add(which)
                        Toast.makeText(
                                this@MainActivity,
                                "Checks selected:(" + itemsSeleccionados.size + ")",
                                Toast.LENGTH_SHORT)
                                .show()
                    } else if (itemsSeleccionados.contains(which)) {
                        // Remover indice sin selección
                        itemsSeleccionados.remove(Integer.valueOf(which))
                    }
                }

        return builder.create()
    }

    fun customDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val v = inflater.inflate(R.layout.custom_dialog, null)
        builder.setView(v)

        val signup = v.findViewById(R.id.crear_boton) as Button
        val signin = v.findViewById(R.id.entrar_boton) as Button

        signup.setOnClickListener { }

        signin.setOnClickListener { }

        return builder.create()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> creatSimpleAlertDialog().show()
            R.id.button2 -> SimpleDialog().show(supportFragmentManager, "SimpleDialog")
            R.id.button3 -> createSingleListDialog().show()
            R.id.button4 -> createRadioListDialog().show()
            R.id.button5 -> createMultipleListDialog().show()
            R.id.button6 -> customDialog().show()
            R.id.button7 -> DateDialog().show(supportFragmentManager, "DateDialog")
            R.id.button8 -> TimeDialog().show(supportFragmentManager, "TimeDialog")
            R.id.button9 -> crearFullScreenDialog()
        }
    }

    private fun crearFullScreenDialog() {
        val fragmentManager = supportFragmentManager
        val newFragment = FullScreenDialog()

        val transaction = fragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.add(android.R.id.content, newFragment, "FullScreenFragment")
                .commit()
    }

    override fun onPossitiveButtonClick() {
        textView!!.text = "OK"
    }

    override fun onNegativeButtonClick() {
        textView!!.text = "FALSE"
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(
                this,
                "Date: $year-$month-$dayOfMonth",
                Toast.LENGTH_LONG)
                .show()

        val fragment:FullScreenDialog? = supportFragmentManager.findFragmentByTag("FullScreenFragment") as? FullScreenDialog
        fragment?.setDateView(year, month, dayOfMonth)

    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        Toast.makeText(
                this,
                "Tiempo: $hourOfDay:$minute",
                Toast.LENGTH_LONG)
                .show()

        val fragment = supportFragmentManager.findFragmentByTag("FullScreenFragment") as? FullScreenDialog
        fragment?.setTimeView(hourOfDay, minute)
    }
}
