package com.chefsito.myownapp.auth.di

import com.chefsito.myownapp.common.network.client.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit = RetrofitClient.get("https://dummyjson.com/")
}