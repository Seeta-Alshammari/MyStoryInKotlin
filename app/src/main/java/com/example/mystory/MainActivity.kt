package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private  var textViewEmail:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email =intent.getStringExtra("email")//لنقل بيانات الايميل الى الواجهه التالية (ينقل الايميل 1)

        connectViews()//يعمل الربط2
        textViewEmail?.text = email//يضع الايميل في :3textview
    }
    private  fun connectViews(){
        textViewEmail = findViewById(R.id.tvEmail)
    }
}