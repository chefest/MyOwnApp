package com.chefsito.myownapp.auth.domain.repository

import com.chefsito.myownapp.auth.domain.models.AuthResponseDomainModel

interface AuthRepository {
    suspend fun postAuth(
        username: String,
        password: String
    ): AuthResponseDomainModel
}