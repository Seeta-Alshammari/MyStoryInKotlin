package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {
    private var editTextTitle:EditText? = null
    private var editTextSubTitle : EditText? = null
    private  var editTextDesc : EditText? = null
    private var buttonAddStory:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)
        connectViews()
        fieldsValidation()
    }
    private fun connectViews(){
      editTextTitle = findViewById(R.id.etTitle)
        editTextSubTitle = findViewById(R.id.etSubTitle)
        editTextDesc = findViewById(R.id.etDescription)
        buttonAddStory = findViewById(R.id.btnAdd)
    }
    private fun fieldsValidation(){
        buttonAddStory?.setOnClickListener {
            val title = editTextTitle?.text.toString()
            val subTitle = editTextSubTitle?.text.toString()
            val desc = editTextDesc?.text.toString()
            if (title.isEmpty()){
                editTextTitle?.error = (getString(R.string.enter_title))

            }else if (subTitle.isEmpty()){
                editTextSubTitle?.error = getString(R.string.enter_sub_title)
            }else if (desc.isEmpty()){
                editTextDesc?.error = getString(R.string.enter_description)
            }else{
                //add Story now all fields have data
                this.finish()
                val  i = Intent(this,MainActivity::class.java)
                i.putExtra("title",title)
                i.putExtra("subtitle",subTitle)
                i.putExtra("desc",desc)
                startActivity(i)
            }
        }
    }
}
