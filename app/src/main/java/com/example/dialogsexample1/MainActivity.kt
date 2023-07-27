package com.example.dialogsexample1

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogsexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            btnDialogFragment.setOnClickListener {
                val myDialogFragment = MyDialogFragment()
                myDialogFragment.show(supportFragmentManager, "teGusta")
            }
            btnFunDialog.setOnClickListener {
                myAlertDialog("Este es el segundo dialog, " +
                        "se utiliza la clase AlertDialog para mostrarlo.")
            }
            btnFunDialogList.setOnClickListener {
                myAlertDialogList("Dilog que muestra una lista.")
            }
        }
        setContentView(binding.root)
    }

    private val actionButton = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            this, android.R.string.ok, Toast.LENGTH_SHORT
        ).show()
        binding.root.setBackgroundColor(Color.GREEN)
    }

    private fun myAlertDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        // Se crea el AlertDialog
        builder.apply {
            // Se asigna el titulo
            setTitle("Dialogo por funcion")
            // Se asigna el cuerpo del mensaje
            setMessage(message)
            // Se define el comportamiento de los botones
            setPositiveButton(
                android.R.string.ok, DialogInterface.OnClickListener(function = actionButton)
            )
            setNegativeButton(android.R.string.cancel) { _, _ ->
                Toast.makeText(context, android.R.string.cancel, Toast.LENGTH_SHORT).show()
                binding.root.setBackgroundColor(Color.RED)
            }
            setNeutralButton("No se que hacer") { _, _ ->
                Toast.makeText(context, "Recordar mas tarde", Toast.LENGTH_SHORT).show()
                binding.root.setBackgroundColor(Color.WHITE)
            }
        }
        // Se muestra el dialog
        builder.show()
    }private fun myAlertDialogList(message: String) {
        val builder = AlertDialog.Builder(this)
        val namesArray = resources.getStringArray(R.array.array_names)
        builder.apply {
            setTitle("Dialogo con lista de nombres")
            setItems(R.array.array_names){ _, which ->
                Toast.makeText(
                    context,
                    namesArray[which],
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        builder.show()
    }
}