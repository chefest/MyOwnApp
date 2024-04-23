package com.chefsito.myownapp.auth.di

import com.chefsito.myownapp.auth.data.datasource.AuthApi
import com.chefsito.myownapp.auth.data.repository.AuthRepositoryImpl
import com.chefsito.myownapp.auth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthRepositoryModule {
    @Provides
    fun provideAuthRepository(
        authApi: AuthApi
    ): AuthRepository = AuthRepositoryImpl(
        authApi = authApi
    )
}