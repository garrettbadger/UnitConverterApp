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
//        Binding allows the programmer to more easily access items in the xml.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateCups.setOnClickListener { calculateCups() }
    }

    fun calculateCups(){
//        This function converts the cups input by the user to the units selected by the user.
        val stringInTextField = binding.cups.text.toString()//Stores user input for cups.
        val cups = stringInTextField.toDoubleOrNull()//Converts the string to a double.
        if (cups == null){
            binding.cupsResult.text="Converted Unit:"
            return
        }
        val selectedId = binding.cupsOptions.checkedRadioButtonId//stores id of which radio button is selected.
        val conversion = when(selectedId){ //determines which unit is selected and is assigned appropriate value.
            R.id.tablespoons -> 16.0 //multiply cups by 16
            R.id.milliliters -> 236.58//multiply cups by 236.58
            else -> 8.0//multiply cups by 8
        }
        var cupsResult = cups * conversion //converts cups to the unit.

        binding.cupsResult.text = cupsResult.toString() //outputs conversion to the user.

    }
}