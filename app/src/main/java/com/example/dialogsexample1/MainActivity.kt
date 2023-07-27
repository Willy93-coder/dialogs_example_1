package com.example.dialogsexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogsexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding){
            btnDialogFragment.setOnClickListener {
                val myDialogFragment = MyDialogFragment()
                myDialogFragment.show(supportFragmentManager, "teGusta")
            }
        }
        setContentView(binding.root)
    }
}