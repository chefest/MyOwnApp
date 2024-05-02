package com.chefsito.myownapp.auth.domain.repository

import com.chefsito.myownapp.auth.data.models.AuthResponseModel
import com.chefsito.myownapp.auth.domain.models.AuthResponseDomainModel

interface AuthRepository {
    suspend fun postAuth(
        username: String,
        password: String
    ): AuthResponseModel
}