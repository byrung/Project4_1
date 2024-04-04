package com.example.project4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1:EditText
    lateinit var edit2:EditText
    lateinit var btnPlus:Button
    lateinit var btnMinus:Button
    lateinit var btnMultiply:Button
    lateinit var btnDivide:Button
    lateinit var btnMod:Button
    lateinit var textResult:TextView
    var result : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnMod = findViewById(R.id.btnMod)
        textResult = findViewById<TextView>(R.id.textResult)

        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnMod.setOnClickListener(btnListener)
    }
    var btnListener = OnClickListener{
        val num1Str = edit1.text.toString()
        val num2Str = edit2.text.toString()

        if(num1Str==""||num2Str==""){
            Toast.makeText(baseContext, "입력X", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }
        val num1 = num1Str.toInt()
        val num2 = num2Str.toInt()
        when(it.id){
            R.id.btnPlus -> result = num1 + num2
            R.id.btnMinus -> result = num1 - num2
            R.id.btnMultiply -> result = num1 * num2
            R.id.btnDivide -> result = num1 / num2
            R.id.btnMod -> result = num1 % num2
        }
        textResult.text = "계산결과: " + result
    }

}