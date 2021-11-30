package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText;  lateinit var edit2: EditText
    lateinit var btnAdd: Button;   lateinit var btnSub: Button;
    lateinit var btnMul: Button;   lateinit var btnDiv: Button
    lateinit var btnRem: Button
    lateinit var textResult: TextView
    lateinit var num1: String;    lateinit var num2: String
    var result: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnRem = findViewById<Button>(R.id.BtnRem)

        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
            else{
                result = num1.toFloat() + num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnSub.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
            else{
                result = num1.toFloat() - num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnMul.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toFloat() * num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnDiv.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toFloat() / num2.toFloat()
                if(num1.toFloat() != 0.0f && num2.toFloat() != 0.0f) {
                    textResult.text = "계산 결과 : " + result.toString()
                }
                else{
                    Toast.makeText(this@MainActivity, "오류 발생! 0을 나눌 수 없습니다!", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }

        btnRem.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toFloat() % num2.toFloat()
                if(num1.toFloat() != 0.0f && num2.toFloat() != 0.0f) {
                    textResult.text = "계산 결과 : " + result.toString()
                }
                else{
                    Toast.makeText(this@MainActivity, "오류 발생! 0을 나눌 수 없습니다!", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }
}