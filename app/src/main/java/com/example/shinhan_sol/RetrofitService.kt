package com.example.shinhan_sol

import com.example.shinhan_sol.data_type.Login
import com.example.shinhan_sol.data_type.OTID
import com.example.shinhan_sol.data_type.SignUp
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @POST("/login")
    fun login(
        @Body login: Login
    ): Call<Login>

    @POST("/signup")
    fun signup(
        @Body signUp: SignUp
    ): Call<SignUp>

    @POST("/signup/quick")
    fun signupOtid(
        @Body otid: String
    ): Call<OTID>

}
