package com.example.lab_6013116

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)//Intent เหทือน page (ที่แยู่ของปลายทาง,ไฟล์ที่ต้องการจะไป)
            intent.putExtra("input1", inputText1.text.toString().toInt())
            intent.putExtra("input2", inputText2.text.toString().toInt())
            startActivity(intent) //start หน้า
        }

        minusButton.setOnClickListener {
            val intent = Intent(this,MinusActivity::class.java)//Intent เหทือน page (ที่แยู่ของปลายทาง,ไฟล์ที่ต้องการจะไป)
            intent.putExtra("input1", inputText1.text.toString().toInt())
            intent.putExtra("input2", inputText2.text.toString().toInt())
            startActivity(intent) //start หน้า
        }
    }
}