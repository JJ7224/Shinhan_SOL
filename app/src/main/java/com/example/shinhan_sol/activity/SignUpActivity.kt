package com.example.shinhan_sol.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.isEmpty
import com.example.shinhan_sol.MasterRetrofit
import com.example.shinhan_sol.R
import com.example.shinhan_sol.data_type.SignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    lateinit var userId: EditText
    lateinit var userPw: EditText
    lateinit var userPwCheck: EditText
    lateinit var userPhoneNum: EditText
    lateinit var userBrith: EditText
    lateinit var userName: EditText
    lateinit var userNickName: EditText
    lateinit var btnRegisterPhoto: Button
    lateinit var btnSignup: Button
    lateinit var btnOverlap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()

        btnSignup.setOnClickListener {
            signUp()
        }

    }

    fun signUp() {
        if (userId.text.isEmpty() || userPw.text.isEmpty() || userPwCheck.text.isEmpty() ||
            userPhoneNum.text.isEmpty() || userBrith.text.isEmpty() || userName.text.isEmpty() ||
            userNickName.text.isEmpty()
        ) {
            Toast.makeText(this@SignUpActivity, "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show()
        } else {


            if (userPw.getText().toString().equals(userPwCheck.getText().toString())) {
                val userId = userId.text.toString()
                val userPassword = userPw.text.toString()
                val userPhoneNum = userPhoneNum.text.toString()
                val userBrith = userBrith.text.toString()
                val userName = userName.text.toString()
                val userNickname = userNickName.text.toString()
                val signUp = SignUp(userId, userBrith, userName, userPhoneNum, userNickname)

                if (!Pattern.matches("^[a-zA-Z0-9]*\$", userId)) {
                    Toast.makeText(this, "아이디는 영문 & 숫자만 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                else if (!Pattern.matches("^[a-zA-Z0-9]*\$", userPassword)) {
                    Toast.makeText(this, "비밀번호는 영문 & 숫자만 가능합니다.", Toast.LENGTH_LONG).show()
                    return
                }
                else {
                    val service = MasterRetrofit().Retrofit()
                    service.signup(signUp).enqueue(object : Callback<SignUp> {
                        override fun onResponse(call: Call<SignUp>, response: Response<SignUp>) {
                            if(response.isSuccessful){
                                Toast.makeText(
                                    this@SignUpActivity, "회원정보가 설정되었습니다!", Toast.LENGTH_LONG).show()
                                val intent = Intent(this@SignUpActivity, OTIDActivity::class.java)
                                startActivity(intent)
                            }
                        }
                        override fun onFailure(call: Call<SignUp>, t: Throwable) {
                            Toast.makeText(
                                this@SignUpActivity, "회원가입이 실패하였습니다.", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }
            else {
                Toast.makeText(this@SignUpActivity, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun overlapID() { // 아이디 중복체크
//        val userId = userId.text.toString()
//
//        val service = MasterRetrofit().Retrofit()
//        service.overlapID(Overlap(userId))
//            .enqueue(object : Callback<OverlapData> {
//                override fun onResponse(call: Call<OverlapData>, response: Response<OverlapData>) {
//                    var data: Boolean = response.body()!!.data
//                    Log.d("retrofitt", "data = $data")
//                    if (data == true) {
//                        Toast.makeText(this@SignUpActivity, "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(this@SignUpActivit, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show()
//
//                    }
//                }
//
//                override fun onFailure(call: Call<OverlapData>, t: Throwable) {
//                    Toast.makeText(this@SignUpActivit, "서버에 연결이 끊어졌습니다.", Toast.LENGTH_SHORT).show()
//                }
//            })
//    }

    fun init() {
        userId = findViewById(R.id.edit_id)
        userPw = findViewById(R.id.edit_pw)
        userPwCheck = findViewById(R.id.edit_pw_check)
        userPhoneNum = findViewById(R.id.edit_phone_num)
        userName = findViewById(R.id.edit_name)
        userBrith = findViewById(R.id.edit_birth)
        userNickName = findViewById(R.id.edit_nickname)
        btnRegisterPhoto = findViewById(R.id.btn_register_photo)
        btnSignup = findViewById(R.id.btn_signup)
        btnOverlap = findViewById(R.id.btn_overlap)
    }
}