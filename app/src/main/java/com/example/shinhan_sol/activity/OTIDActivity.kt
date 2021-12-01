package com.example.shinhan_sol.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.shinhan_sol.MasterRetrofit
import com.example.shinhan_sol.R
import com.example.shinhan_sol.data_type.OTID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OTIDActivity : AppCompatActivity() {

    lateinit var userOTID: EditText
    lateinit var btnOTID: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otidactivity)

        init(this@OTIDActivity)

        btnOTID.setOnClickListener {
            OTIDsignup()
        }
    }

    fun OTIDsignup() {
        val userOTID = userOTID.text.toString()

        val service = MasterRetrofit().Retrofit()
        service.signupOtid(userOTID).enqueue(object : Callback<OTID> {

            override fun onResponse(call: Call<OTID>, response: Response<OTID>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@OTIDActivity, "간편인증번호가 설정되었습니다.", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this@OTIDActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<OTID>, t: Throwable) {
                Toast.makeText(this@OTIDActivity, "입력 정보가 잘못되었습니다",
                    Toast.LENGTH_SHORT).show()


            }

        })
    }


    fun init(activity: Activity) {
        userOTID = findViewById(R.id.edit_OTID)
        btnOTID = findViewById(R.id.btn_OTID)
    }
}

