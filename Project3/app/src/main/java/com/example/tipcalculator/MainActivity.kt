package com.example.tipcalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun calculateTip(view:View) {
        if (binding.billAmount.text.isNotEmpty()) {
            val dollarValue = binding.billAmount.text.toString()
            val amt = dollarValue.toDouble()

            val tenValue = amt + (amt * 0.10)
            binding.output.text = tenValue.toString()

            val fifteenValue = amt + (amt * 0.15)
            binding.output.text = fifteenValue.toString()

            val twentyValue = amt+ (amt * 0.20)
            binding.output.text = twentyValue.toString()


            val textStatus: String = String.format(
                "The tips are as follows:\n" +
                        "10%% " + "=" + " %s\n" +
                        "15%% " + "=" +" %s\n" +
                        "20%% " + "=" + " %s\n",
                """$tenValue""",
                """$fifteenValue""",
                """$twentyValue"""
            )
            binding.output.text = textStatus
        } else {
            "You must enter an amount".also { binding.output.text = it }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val userText = binding.output.text
        outState.putCharSequence("savedText", userText)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val userText = savedInstanceState.getCharSequence("savedText")
        binding.output.text = userText
    }
}