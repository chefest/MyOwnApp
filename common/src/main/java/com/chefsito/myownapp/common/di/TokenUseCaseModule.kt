package com.chefsito.myownapp.common.di

import com.chefsito.myownapp.common.core.token.TokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TokenUseCaseModule {
    @Singleton
    @Provides
    fun providesTokenUseCase(): TokenUseCase = TokenUseCase()
}