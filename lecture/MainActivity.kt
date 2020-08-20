package com.example.lec02_basiclab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun plusFunction(int1:Int,int2:Int):Int{
            return int1+int2
        }

        submitBTN.setOnClickListener {
            /*
            //คำสังทั่วไป
            var ans:Int//var ชื่อ:ชนืด
            var a = 30
            var b = 20
            val max = if(a>b) a else b //assign ค่าได้แค่ทีเดียวเท่านั้น
            ans = plusFunction(1,2)
            Log.d("Test",ans.toString())//แสดง log
            Log.d("Test max","Max = $max")
            Toast.makeText(this,editText.text.toString(),Toast.LENGTH_LONG).show()//Toast.makeText เป็นการแสดง pop-up (layout,text,length)
            //Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()//ใช้ได้เหมือนกัน
            //Toast.makeText(this,"Hello+editText.text.tostring()",Toast.LENGTH_LONG).show()//ใช้ได้เหมือนกัน
            editText.setText(ans.toString())
             */
            /*
            //when
            var x = 20
            when (x){//คล้ายกับ Switch case
                10 -> Log.d("Result of x","x = $x")
                else -> {
                    Log.d("Result of x","x != $x")
                }
            }
             */
            // for and List , mutableList , hashSet , hashMap
            /*
            val items = listOf<Int>(1,2,3,4,5,6,7,8,9)//<ชนิดที่เก็บ>(ค่าข้างใน)
            for(index in items.indices)
                Log.d("Result","value: ${items[index]},")
            for((index,value) in items.withIndex())//ค่าของ items.withIndex() จะเป็น (0,1) , (1,2) , ... , (8,9)
                Log.d("Result","index: $index = $value")
            for( i in 1..10) // 1 ถึง 10 แต่ใช้ 10..1 ไม่ได้ ต้องใช้ 10 downTo 1
                Log.d("Result","i = $i")
            for( i in 1 until 10 step 2) // step 2 = i เเพิ่มทีละ2 , 1 untill 10 = 1..10
                Log.d("Result","i = $i")
            */
            /*
            val items = mutableListOf<Int>(1,2,3,4,5,6,7,8,9)//สามารถ add item ได้
            items.add(10) //add an item
            for (i in items)
                Log.d("Result","value = $i")
            Log.d("Result","first item = "+items.first().toString())
            Log.d("Result","last item = "+items.last().toString())
            Log.d("Result","filter item = "+items.filter( it%2!=0).toString())
            */
            /*
            val items = hashSetOf<String>("g","e","c","d","e")//ชจัดตัวซ้ำ
            for(item in items.toSortedSet())//เรียงข้อมูลให้เลย
                Log.d("Result","item =$item")
            */
            /*
            val items = hashMapOf<String,Int>("First" to 1,"Second" to 2)
            Log.d("Result",items["Frist"].toString())// Result: 1
            */
            // Change page
            val intent = Intent(this, HomeActivity::class.java)//Intent เหทือน page (ที่แยู่ของปลายทาง,ไฟล์ที่ต้องการจะไป)
            intent.putExtra("username",nameText.text.toString())
            intent.putExtra("password",passText.text.toString())
            startActivity(intent) //start หน้า
        }


    }
}