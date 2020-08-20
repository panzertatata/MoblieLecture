package com.example.lab_6013116

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_minus.*

class MinusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minus)
        val bundle = intent.extras
        var firstVar:Int
        var secondVar:Int
        var result: Int
        if(bundle != null){
            firstVar = bundle.getInt("input1")
            secondVar = bundle.getInt("input2")
            result = firstVar-secondVar
            firstText2.setText(firstVar.toString())
            secondText2.setText(secondVar.toString())
            resultText2.setText("$result")
        }
    }
}