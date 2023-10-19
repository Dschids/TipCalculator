package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var mealCost = 0.00
    var tipAmount = ""
    var tipDouble: Double = 0.00
    var tipCalc = 0.00
    var totalCost = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cost = findViewById<EditText>(R.id.idEditTextMealCost)
        val tip = findViewById<Spinner>(R.id.idSpnrTip)
        val calculate = findViewById<Button>(R.id.idBtnCalc)
        val result = findViewById<TextView>(R.id.idTxtTipResult)

        calculate.setOnClickListener {
            val dollarFormat = DecimalFormat("$###,###.00")
            mealCost = cost.text.toString().toDouble()
            tipAmount = tip.selectedItem.toString()
            
            when (tipAmount){
                "5%" -> tipDouble = .05
                "10%" -> tipDouble = .10
                "15%" -> tipDouble = .15
                "20%" -> tipDouble = .20
                "25%" -> tipDouble = .25
            }
            tipCalc = tipDouble * mealCost
            totalCost = tipCalc + mealCost
            val tipFormatted = dollarFormat.format(tipCalc)
            val totalFormatted = dollarFormat.format(totalCost)

            result.text = "A $tipAmount tip would be: $tipFormatted. \nTotal cost with tip is $totalFormatted"


        }
    }
}