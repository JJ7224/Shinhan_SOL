package com.example.shinhan_sol

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        spannable()
    }
//    오류 잡아야됨
//    fun spannable() {
//        val text: TextView = findViewById(R.id.text_effect)
//
//        val content: String = text.getText().toString()
//        val spannableString = SpannableString(content)
//
//        val word: String = "로그인방식"
//        val start = content.indexOf(word)
//        val end = start + word.length
//
//        spannableString.setSpan(ForegroundColorSpan(Color.parseColor
//                    ("#3B85CD")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        text.setText(spannableString)
//    }
}