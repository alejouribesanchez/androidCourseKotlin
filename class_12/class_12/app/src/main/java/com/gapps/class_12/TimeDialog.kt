package com.gapps.class_12

/**
 * Created by alejo on 6/2/17.
 */

import android.annotation.TargetApi
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.format.DateFormat

import java.util.Calendar

/**
 * Fragmento con un diálogo de elección de tiempos
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class TimeDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Iniciar con el tiempo actual
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Retornar en nueva instancia del dialogo selector de tiempo
        return TimePickerDialog(
                activity,
                activity as TimePickerDialog.OnTimeSetListener,
                hour,
                minute,
                DateFormat.is24HourFormat(activity))
    }

}
