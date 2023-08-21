package com.example.grammartestintership.dialogHelper

import android.app.AlertDialog
import android.content.Context
import com.example.grammartestintership.R

class DialogHelper(private val context: Context) {

    interface GrammarTestCallback {
        fun onPositiveAnswer()
        fun onNegativeAnswer()
    }

    fun showAlertDialog(
        title: String,
        positiveText: String,
        negativeText: String,
        onPositiveClick: () -> Unit,
        onNegativeClick: () -> Unit
    ) {
        val alertDialogBuilder = AlertDialog.Builder(context, R.style.DialogStyle)
        alertDialogBuilder.setTitle(title)
            .setPositiveButton(positiveText) { _, _ ->
                onPositiveClick.invoke()
            }
            .setNegativeButton(negativeText) { _, _ ->
                onNegativeClick.invoke()
            }
            .setCancelable(false)
            .show()
    }
}