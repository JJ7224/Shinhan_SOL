package com.example.shinhan_sol

import com.example.shinhan_sol.data_type.Login
import com.example.shinhan_sol.data_type.SignUp
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @POST("/login")
    fun login(
        @Body login: Login
    ): Call<Any?>

    @POST("/login/quick")
    fun loginOTID(
        @Query("quickpw") quickpw: String
    ): Call<Any?>

    @Multipart
    @POST("/signup")
    fun signup(
        @Part image: SignUp,
        @PartMap data: HashMap<String, RequestBody>
    ): Call<Any?>

    @POST("/signup/quick")
    fun signupOTID(
        @Query("quickpw") quickpw: String
    ): Call<Any?>
}
