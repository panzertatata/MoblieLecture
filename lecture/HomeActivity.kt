package com.example.lec02_basiclab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle = intent.extras
        val user:String
        val pass:String
        if(bundle != null){
            user = bundle.getString("username").toString()
            pass = bundle.getString("password").toString()
            resUserText.text = user
            resPassText.text = pass

        }
    }
}