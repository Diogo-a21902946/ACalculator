package com.example.acalculator

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.acalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.button1.setOnClickListener { onClickSymbols("1") }
        binding.button2.setOnClickListener { onClickSymbols("2") }
        binding.button3.setOnClickListener { onClickSymbols("3") }
        binding.button4.setOnClickListener { onClickSymbols("4") }
        binding.button5.setOnClickListener { onClickSymbols("5") }
        binding.button6.setOnClickListener { onClickSymbols("6") }
        binding.button7.setOnClickListener { onClickSymbols("7") }
        binding.button8.setOnClickListener { onClickSymbols("8") }
        binding.button9.setOnClickListener { onClickSymbols("9") }
        binding.button0.setOnClickListener { onClickSymbols("0") }
        binding.buttonAddition.setOnClickListener { onClickSymbols("+") }
        binding.buttonSubtrair.setOnClickListener { onClickSymbols("-") }
        binding.buttonMultiplicar.setOnClickListener { onClickSymbols("*") }
        binding.buttonDividir.setOnClickListener { onClickSymbols("/") }
        binding.buttonPonto.setOnClickListener { onClickSymbols(".") }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
        binding.buttonC.setOnClickListener { onClickApagar() }
        binding.buttonDeleteLast.setOnClickListener { onClickApagarUltimo() }

    }


    private fun onClickSymbols(symbol : String){
        Log.i(TAG,"Click no botão $symbol")
        if(binding.textVisor.text == "0"){
            binding.textVisor.text = "$symbol"
        }else{
            binding.textVisor.append("$symbol")
        }
    }


    private fun onClickApagar(){
        Log.i(TAG,"Click no botão C")
        binding.textVisor.text= "0"
    }

    private fun onClickApagarUltimo(){
        Log.i(TAG,"Click no botão CE")
        binding.textVisor.text = binding.textVisor.text.substring(0, binding.textVisor.text.length-1)
    }

    private fun onClickPercentagem(){
        Log.i(TAG, "Click no botão %")
        binding.textVisor.text = binding.textVisor.text
    }

    private fun onClickEquals() {
        Log.i(TAG,"Click no botão =")
        val expression = ExpressionBuilder(
            binding.textVisor.text.toString()
        ).build()
        binding.textVisor.text = expression.evaluate().toString()
        Log.i(TAG,"O resultado da expressão é ${binding.textVisor.text}")
    }

}