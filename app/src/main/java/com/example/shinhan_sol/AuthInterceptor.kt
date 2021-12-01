package com.example.shinhan_sol

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer " + App.prefs.token ?: "")
            .build()
        return chain.proceed(req)
    }
}