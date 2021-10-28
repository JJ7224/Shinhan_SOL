package com.example.shinhan_sol.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.shinhan_sol.MasterRetrofit
import com.example.shinhan_sol.R
import com.example.shinhan_sol.data_type.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var userId: EditText
    lateinit var userPw: EditText
    lateinit var login_btn_login: EditText
    init {
        userId = findViewById(R.id.login_edit_id)
        userPw = findViewById(R.id.login_edit_pw)
        login_btn_login = findViewById(R.id.login_btn_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_login.setOnClickListener {
            val id = userId.text.toString()
            val pw = userPw.text.toString()
            val login = Login(id, pw)
            (application as MasterRetrofit).service.login(login)
                .enqueue(object : Callback<Any?> {
                    override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    override fun onFailure(call: Call<Any?>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}