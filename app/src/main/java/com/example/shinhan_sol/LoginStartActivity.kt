package com.example.shinhan_sol

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView

class LoginStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_start)

        val btn_start_login: Button = findViewById(R.id.btn_start_login)
        spannable()

        btn_start_login.setOnClickListener {
            val intent = Intent(this@LoginStartActivity, SelectLoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun spannable() {
        val text: TextView = findViewById(R.id.text_effect)

        val content: String = text.getText().toString()
        val spannableString = SpannableString(content)

        val word: String = "금용솔루션"
        val start = content.indexOf(word)
        val end = start + word.length

        spannableString.setSpan(
            ForegroundColorSpan(
                Color.parseColor
            ("#3B85CD")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setText(spannableString)
    }
}