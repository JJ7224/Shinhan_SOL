package com.example.shinhan_sol.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.shinhan_sol.MasterRetrofit
import com.example.shinhan_sol.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class OTIDActivity : AppCompatActivity() {

    lateinit var userOTID: EditText
    lateinit var btnOTID: Button

    init {
        userOTID = findViewById(R.id.edit_OTID)
        btnOTID = findViewById(R.id.btn_OTID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otidactivity)


    }

    fun OTIDsignup() {
        val userOTID = userOTID.text.toString()
        (application as MasterRetrofit).service.signupOTID(userOTID)
            .enqueue(object : Callback<Any?> {
                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@OTIDActivity, "간편인증번호가 설정되었습니다.", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this@OTIDActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Any?>, t: Throwable) {
                    if (userOTID.toString().isEmpty()) {
                        Toast.makeText(this@OTIDActivity, "입력 칸을 다 채워주세요.", Toast.LENGTH_SHORT).show()
                    }
//                    else if () {
//
//                    }
                }
            })
    }

}