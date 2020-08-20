package com.example.lab_6013116

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val bundle = intent.extras
        var firstVar:Int
        var secondVar:Int
        var result: Int
        if(bundle != null){
            firstVar = bundle.getInt("input1")
            secondVar = bundle.getInt("input2")
            result = firstVar+secondVar
            firstText.setText(firstVar.toString())
            secondText.setText(secondVar.toString())
            resultText.setText("$result")
        }
    }
}