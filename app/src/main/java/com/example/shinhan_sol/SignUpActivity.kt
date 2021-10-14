package com.example.shinhan_sol

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        init(this@SignUpActivity)

    }

    fun signup(activity: Activity) {
        if(userPw.getText().toString().equals(userPwCheck.getText().toString())) {

        }
    }

    fun init(activity: Activity) {
        userId = activity.findViewById(R.id.edit_id)
        userPw = activity.findViewById(R.id.edit_pw)
        userPwCheck = activity.findViewById(R.id.edit_check_pw)
        userEmail = activity.findViewById(R.id.edit_email)
        userName = activity.findViewById(R.id.edit_name)
        userBrith = activity.findViewById(R.id.edit_brith)
        userNickName = activity.findViewById(R.id.edit_nick_name)
        btnRegisterPhoto = activity.findViewById(R.id.btn_register_photo)
        checkAgree = activity.findViewById(R.id.check_agree)
        btnSignup = activity.findViewById(R.id.btn_signup)
        btnOverlap = activity.findViewById(R.id.btn_overlap)
    }
}