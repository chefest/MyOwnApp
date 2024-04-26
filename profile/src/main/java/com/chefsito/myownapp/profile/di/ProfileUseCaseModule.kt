package com.chefsito.myownapp.profile.di

import com.chefsito.myownapp.profile.domain.repository.ProfileRepository
import com.chefsito.myownapp.profile.domain.usecases.ProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ProfileUseCaseModule {
    @Provides
    fun provideProfileUseCase(
        profileRepository: ProfileRepository
    ): ProfileUseCase = ProfileUseCase(
        profileRepository = profileRepository
    )
}