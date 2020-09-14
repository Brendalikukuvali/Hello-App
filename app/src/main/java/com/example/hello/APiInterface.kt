package com.example.hello

import Activities.RegisterationActivity
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<LoginResponse>


    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>

    @POST("register-course")
    fun registerCourse(
        @Body requestBody: RequestBody,
        @Header("Authorization") accessToken: String
    ): Call<RegisterationActivity>

}
}