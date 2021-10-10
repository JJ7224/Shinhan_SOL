package com.example.shinhan_sol

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup

class SignUpActivity : AppCompatActivity() {

    lateinit var userId: EditText
    lateinit var userPw: EditText
    lateinit var userPwCheck: EditText
    lateinit var userEmail: EditText
    //중간에 주민등록번호 넣어야함
    lateinit var userName: EditText
    lateinit var userNickName: EditText
    lateinit var btnRegisterPhoto: Button
    lateinit var checkAgree: CheckBox
    lateinit var btnSignup: Button
    lateinit var btnOverlap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

    }

    fun signup(activity: Activity) {


    }

    fun init(activity: Activity) {
        userId = activity.findViewById(R.id.edit_id)
        userPw = activity.findViewById(R.id.edit_pw)
        userPwCheck = activity.findViewById(R.id.edit_check_pw)
        userEmail = activity.findViewById(R.id.edit_email)
        userName = activity.findViewById(R.id.edit_name)
        //중간에 주민등록번호 넣어야함
        userNickName = activity.findViewById(R.id.edit_nick_name)
        btnRegisterPhoto = activity.findViewById(R.id.btn_register_photo)
        checkAgree = activity.findViewById(R.id.check_agree)
        btnSignup = activity.findViewById(R.id.btn_signup)
        btnOverlap = activity.findViewById(R.id.btn_overlap)
    }
}