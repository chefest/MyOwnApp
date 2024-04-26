package com.chefsito.myownapp.profile.di

import com.chefsito.myownapp.profile.data.datasource.ProfileApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ProfileApiModule {

    @Provides
    fun provideAuthApi(
        retrofit: Retrofit
    ): ProfileApi = retrofit.create(ProfileApi::class.java)
}