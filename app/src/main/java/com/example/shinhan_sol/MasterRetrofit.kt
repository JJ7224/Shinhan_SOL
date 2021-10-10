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
            .baseUrl("ddd")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        service = retrofit.create(RetrofitService::class.java)
    }

    fun checkLogin(): Boolean {
        //로그인이 되었는가, 안되었는가 확인
        return true
    }

    fun getUserToken(): String? {
        //로그인이 됐으면 토큰주고, 아니면 NULL
        val token = "토큰"
        return token
    }
}