package com.example.shinhan_sol

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("/login")
    fun login(
        @Body login: Login
    ):Call<Any?>

    @POST("/signup")
    fun signup(
        @Body signUp: SignUp
    ):Call<Any?>
}