package com.example.shinhan_sol.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.shinhan_sol.R

class SignUpActivity : AppCompatActivity() {

    lateinit var userId: EditText
    lateinit var userPw: EditText
    lateinit var userPwCheck: EditText
    lateinit var userEmail: EditText
    lateinit var userBrith: EditText
    lateinit var userName: EditText
    lateinit var userNickName: EditText
    lateinit var btnRegisterPhoto: Button
    lateinit var checkAgree: CheckBox
    lateinit var btnSignup: Button
    lateinit var btnOverlap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()

    }

    fun signup(activity: Activity) {

        if(userPw.getText().toString().equals(userPwCheck.getText().toString())) {

        }
    }

    fun init() {
        userId = findViewById(R.id.edit_id)
        userPw = findViewById(R.id.edit_pw)
        userPwCheck = findViewById(R.id.edit_check_pw)
        userEmail = findViewById(R.id.edit_email)
        userName = findViewById(R.id.edit_name)
        userBrith = findViewById(R.id.edit_brith)
        userNickName = findViewById(R.id.edit_nick_name)
        btnRegisterPhoto = findViewById(R.id.btn_register_photo)
        checkAgree = findViewById(R.id.check_agree)
        btnSignup = findViewById(R.id.btn_signup)
        btnOverlap = findViewById(R.id.btn_overlap)
    }
}