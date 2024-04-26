package com.chefsito.myownapp.profile.domain.repository

import com.chefsito.myownapp.profile.data.models.ProfileResponseModel

interface ProfileRepository {
    suspend fun getProfile(token: String): ProfileResponseModel
}