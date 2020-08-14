package com.example.hello

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APiClient {
    var client = OkHttpClient.Builder().build()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://courses-service.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}