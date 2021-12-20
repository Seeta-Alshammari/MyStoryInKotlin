package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonLogin: Button? = null
    private var checkboxView: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        connectViews()
        login()
        //checkFields()
    }

    private fun connectViews() {
        editTextUsername = findViewById(R.id.etUsername)
        editTextPassword = findViewById(R.id.etPassword)
        buttonLogin = findViewById(R.id.btLogin)
        checkboxView = findViewById(R.id.checkbox)
    }

    private fun login() {
        val arr: ArrayList<User> = ArrayList()
        arr.add(User("Seeta123@gmail.com", "1234"))
        arr.add(User("Sara1232@gmail.com", "123488"))
        arr.add(User("Ali4423@gmail.com", "123455"))
        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString() //مدخل بواسطة المستخدم (الايميل)
            val password = editTextPassword?.text.toString() // مدخل بواسطة المستخدم (كلمة المرور)
            val user = User(username, password)
            for (userArray in arr) {
                if (userArray.email == user.email && userArray.password == user.password) {
                    // Toast.makeText(this,"Welcome${user.email}",Toast.LENGTH_LONG).show()
                    finish()
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("email", userArray.email)
                    startActivity(i)
                    break
                } else {
                    Toast.makeText(this, "check your data", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun checkFields() {
        buttonLogin?.setOnClickListener {
            if (editTextUsername?.text?.isEmpty() == true

               // || checkboxView?.isChecked != true
            ) {
                    editTextUsername?.error= ("Enter your email")
                //Toast.makeText(this, "Enter your data", Toast.LENGTH_LONG).show()
            } else if ( editTextPassword?.text?.isEmpty() == true) {
                editTextPassword?.error = "Enter your password"
               // Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }
        }
    }
}



