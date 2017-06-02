package com.gapps.class_12

/**
 * Created by alejo on 6/2/17.
 */

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment

import java.util.Calendar

/**
 * Fragmento con un diálogo de elección de fechas
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class DateDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Obtener fecha actual
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Retornar en nueva instancia del dialogo selector de fecha
        return DatePickerDialog(
                activity,
                activity as DatePickerDialog.OnDateSetListener,
                year,
                month,
                day)
    }


}