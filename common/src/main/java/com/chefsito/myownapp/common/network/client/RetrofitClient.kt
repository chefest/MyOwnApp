package com.chefsito.myownapp.common.network.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun get(server: String): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(server)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}