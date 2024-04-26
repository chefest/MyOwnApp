package com.chefsito.myownapp.profile.di

import com.chefsito.myownapp.profile.data.datasource.ProfileApi
import com.chefsito.myownapp.profile.data.repository.ProfileRepositoryImpl
import com.chefsito.myownapp.profile.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ProfileRepositoryModule {

    @Provides
    fun provideProfileRepository(
        profileApi: ProfileApi
    ): ProfileRepository = ProfileRepositoryImpl(profileApi  = profileApi)
}