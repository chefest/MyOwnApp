package com.chefsito.myownapp.auth.di

import com.chefsito.myownapp.auth.domain.repository.AuthRepository
import com.chefsito.myownapp.auth.domain.usecases.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun providesAuthUseCase(
        authRepository: AuthRepository
    ): AuthUseCase = AuthUseCase(
        authRepository = authRepository
    )
}