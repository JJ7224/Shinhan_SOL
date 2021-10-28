package com.example.shinhan_sol

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterRetrofit : Application() {

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()

        retrofit()
    }

    fun retrofit() {
        val header = Interceptor {
            val original = it.request()
            if (checkLogin()) {
                getUserToken()?.let { token ->
                    val request = original.newBuilder()
                        .header("esfafds", "token " + token)
                        .build()
                    it.proceed(request)
                }
            } else {
                it.proceed(original)
            }
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.80.161.222:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        service = retrofit.create(RetrofitService::class.java)
    }

    fun checkLogin(): Boolean {
        //DB 써서 로그인 됐는지 안됐는지 확인하는 함수
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return false
        else return true
    }

    fun getUserToken(): String? {
        //로그인이 됐으면 토큰주고, 아니면 NULL
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token == "null") return null
        else return token
    }
}