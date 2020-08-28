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
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newName = namePlainText.text.toString()
        main_Listview.adapter = myCustomAdapter()//(ข้อมูลที่ส่งไป)
        val ClassAdapter = main_Listview.adapter as myCustomAdapter

        addButton.setOnClickListener {
            val newName = namePlainText.text.toString()
            ClassAdapter.addname(newName)
        }

//        main_Listview.setOnItemClickListener { adapterView, view, position, id ->
//            val item = adapterView.getItemIdAtPosition(position).to(String)
//            Toast.makeText(this,"${item} $position" , Toast.LENGTH_SHORT).show()
//        }

    }

    private class myCustomAdapter(): BaseAdapter(){//เพราะฉะนั้น ฺทุกอย่างใน BaseAdapter สามารถถูกใช้ในนี้ได้ //การใส่ข้อมูลลง list ต้องทำผ่าน Adapter
//        private val mContext: Context
        private val names = mutableListOf<String>("Bob","John","Jane","Tom","Nancy")
//        private val days = arrayListOf<String>("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        private val color = arrayListOf<String>("#FF6347","#FFFF00","#EE82EE","#3CB371","#FFA500","#1E90FF","#6A5ACD")
//        init { //ทำครั้งแรกเมื่อเจ้ามา
//            mContext = context
//        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getItemId(position : Int): Long {//แต่ละ position ต้องการตั้งชื่อว่าอะไร (ID)
            return position.toLong()
        }

        override fun getCount(): Int {//จำนวน Record ที่อยู่ใร GetView
            //return 5//แสดง 5 ตัว
            return names.size//ทำให้การแสดงผลเราขึ้นตามจำนวนข้อมูลใน name
        }

        fun addname(name:String){
            names.add(name)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {//ต้องการเอาค่าไปแสดงใน listView //(ตำแหน่งอ้างอิงในListView,objectที่เป็นView,)

            val rowMain:View

            if(convertView == null){
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main,viewGroup,false)//โยนเ Template ข้าไปใส่ใน Listview
                Log.d("getview","loading data")
                val viewHolder = ViewHolder(rowMain.name_Textview,rowMain.position_Textview)
                rowMain.tag = viewHolder
            }
            else{
                rowMain = convertView
            }

            rowMain.setOnClickListener {
                rowMain.animate().setDuration(500).alpha(0F).withEndAction ({
                    names.removeAt(position)
                    notifyDataSetChanged()//ทำให้ Listview refresh})//alpha ทำให้มันจางลงง
                    rowMain.setAlpha(1.0F)//ที่ลางท้ายด้วย F คือบอกว่าให้ตัวเลขที่อยู่หน้า F เป็น Float
                })
            }

            val viewHolder = ViewHolder(rowMain.name_Textview,rowMain.position_Textview)
            viewHolder.nameTextView.text = names[position%7] //ใช้ names.get(position) ได้เหมือนกัน
            viewHolder.positionTextView.text = "Row Number : " + position.toString() // ใช้ $position ได้เหมือนกัน

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
    private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)
}