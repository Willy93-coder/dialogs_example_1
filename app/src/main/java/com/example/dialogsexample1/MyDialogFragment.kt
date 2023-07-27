package com.example.dialogsexample1

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    // Se crea la estructura del dialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            builder.setMessage(R.string.my_first_dialog)
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    // Acciones si se pulsa SI
                    Log.d("DEBUG", "Accones si SI")
                    Toast.makeText(it, "Acciones si SI", Toast.LENGTH_SHORT).show()
                }.setNegativeButton(android.R.string.no) { dialog, which ->
                    // Acciones si se pulsa NO
                    Log.d("DEBUG", "Accones si NO")
                    Toast.makeText(it, "Acciones si NO", Toast.LENGTH_SHORT).show()
                }
            builder.create()
        } ?: throw IllegalStateException("La activity no puede ser nula")
    }
}