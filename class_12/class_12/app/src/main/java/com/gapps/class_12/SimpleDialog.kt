package com.gapps.class_12


import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog

/**
 * A simple [Fragment] subclass.
 */
class SimpleDialog : DialogFragment() {
    internal lateinit var listener: OnSimpleDialogListener
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return createSimpleDialog()
    }


    fun createSimpleDialog(): AlertDialog {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("OK"
                ) { dialog, which ->
                    // Actions
                    listener.onPossitiveButtonClick()
                }
                .setNegativeButton("CANCEL"
                ) { dialog, which ->
                    // Actions
                    listener.onNegativeButtonClick()
                }

        return builder.create()
    }

    interface OnSimpleDialogListener {
        fun onPossitiveButtonClick() // Event Botton negative
        fun onNegativeButtonClick() // Event Botton Right
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            listener = activity as OnSimpleDialogListener

        } catch (e: ClassCastException) {
            throw ClassCastException(
                    activity.toString() + " not implement OnSimpleDialogListener")

        }

    }

}// Required empty public constructor


