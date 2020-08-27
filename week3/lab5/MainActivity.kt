package com.example.lab05

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_Listview.adapter = myCustomAdapter(this)//(ข้อมูลที่ส่งไป)
    }

    private class myCustomAdapter(context: Context): BaseAdapter(){//เพราะฉะนั้น ฺทุกอย่างใน BaseAdapter สามารถถูกใช้ในนี้ได้ //การใส่ข้อมูลลง list ต้องทำผ่าน Adapter
        private val mContext: Context
        private val names = arrayListOf<String>("Bob","John","Jane","Tom","Nancy")
        private val days = arrayListOf<String>("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        private val color = arrayListOf<String>("#FF6347","#FFFF00","#EE82EE","#3CB371","#FFA500","#1E90FF","#6A5ACD")
        init { //ทำครั้งแรกเมื่อเจ้ามา
            mContext = context
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position : Int): Long {//แต่ละ position ต้องการตั้งชื่อว่าอะไร (ID)
            return position.toLong()
        }

        override fun getCount(): Int {//จำนวน Record ที่อยู่ใร GetView
            //return 5//แสดง 5 ตัว
            return days.size*3//ทำให้การแสดงผลเราขึ้นตามจำนวนข้อมูลใน name
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {//ต้องการเอาค่าไปแสดงใน listView //(ตำแหน่งอ้างอิงในListView,objectที่เป็นView,)

            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main,viewGroup,false)//โยนเ Template ข้าไปใส่ใน Listview

            rowMain.name_Textview.text = days[position%7] //ใช้ names.get(position) ได้เหมือนกัน
            Log.d("test",days[position%7])
            rowMain.position_Textview.text = "Row Number : " + position.toString() // ใช้ $position ได้เหมือนกัน

            if(position%7>=0) {
                val i = (position % 7)
                rowMain.setBackgroundColor(Color.parseColor(color[i]))
            }

            return rowMain

//            val textView = TextView(mContext)//ข้อมูลในแต่ละ position เรีกยว่า Textview(context ที่จะใส่
//            textView.text = "Hello world"+(position+1).toString()
//            return textView
        }

    }
}