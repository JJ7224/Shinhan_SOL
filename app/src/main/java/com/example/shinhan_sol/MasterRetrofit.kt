package com.example.shinhan_sol

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterRetrofit {

    fun TokenRetrofit(): RetrofitService {

        val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()

        val retrofit: Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://192.168.0.21:8040/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        return service
    }

    fun Retrofit(): RetrofitService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.21:8040/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        return service
    }
}