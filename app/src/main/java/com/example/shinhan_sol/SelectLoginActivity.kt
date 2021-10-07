package com.example.shinhan_sol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SelectLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_login)

        val btn_login: Button = findViewById(R.id.btn_login)
        val btn_OTID: Button = findViewById(R.id.btn_OTID)
        val text_signup:TextView = findViewById(R.id.text_signup)

        text_signup.setOnClickListener {
            val intent_signup = Intent(this@SelectLoginActivity, SignUpActivity::class.java)
            startActivity(intent_signup)
        }

        btn_OTID.setOnClickListener {
            val intent_OTID = Intent(this@SelectLoginActivity, OTIDActivity::class.java)
            startActivity(intent_OTID)
        }

        btn_login.setOnClickListener {
            val intent_login = Intent(this@SelectLoginActivity, LoginActivity::class.java)
            startActivity(intent_login)
        }
    }
}