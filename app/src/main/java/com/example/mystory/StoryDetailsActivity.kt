package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity : AppCompatActivity() {
    private var toolbarView:Toolbar? = null
    private var textViewStoryDesc:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()
        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    //استقبال المتغيرات
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("desc")
        supportActionBar?.title = title
        toolbarView?.setNavigationOnClickListener {
            onBackPressed()
        }
        textViewStoryDesc?.text = description
        textViewStoryDesc?.movementMethod = ScrollingMovementMethod()

    }
    private fun connectViews(){
        toolbarView = findViewById(R.id.toolbar)
        textViewStoryDesc = findViewById(R.id.tvDesc)
    }
}