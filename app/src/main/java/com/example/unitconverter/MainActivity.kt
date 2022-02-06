package com.example.unitconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateCups.setOnClickListener { calculateCups() }
    }

    fun calculateCups(){
        val stringInTextField = binding.cups.text.toString()
        val cups = stringInTextField.toDoubleOrNull()
        if (cups == null){
            binding.cupsResult.text="Converted Unit:"
            return
        }
        val selectedId = binding.cupsOptions.checkedRadioButtonId
        val conversion = when(selectedId){
            R.id.tablespoons -> 16.0 //multiply cups by 16
            R.id.milliliters -> 236.58//multiply cups by 236.58
            else -> 8.0//multiply cups by 8
        }
        var cupsResult = cups * conversion

        binding.cupsResult.text = cupsResult.toString()

    }
}