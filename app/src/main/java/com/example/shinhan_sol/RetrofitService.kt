package com.example.shinhan_sol

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*


interface RetrofitService {

    @POST("/login")
    fun login(
        @Body login: Login
    ): Call<Any?>

    @Multipart
    @POST("/signup")
    fun signup(
        @Part image: SignUp,
        @PartMap data: HashMap<String, RequestBody>
    ): Call<Any?>
}
