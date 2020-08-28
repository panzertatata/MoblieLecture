package com.example.lab04

import android.app.ListActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class MainActivity : ListActivity() {
    var mobileList = arrayOf("Samsung" , "LG" , "Apple" , "Vivo" , "Mi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)//บอกว่าจะเชื่อมกับ layout ไฟล์ไหน
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,mobileList)//(,template ที่ให้มันแสดงผล,ข้อมูลที่จะใส่)//ถ้าไม่มี android. ข้างหน้า R เราจะใช้ layout ที่อยู่ใน project นี้เท่านั้น
        listAdapter = adapter
    }
}