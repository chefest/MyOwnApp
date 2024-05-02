package com.chefsito.myownapp.auth.data.repository

import com.chefsito.myownapp.auth.data.datasource.AuthApi
import com.chefsito.myownapp.auth.data.exceptions.AuthDataException
import com.chefsito.myownapp.auth.data.models.AuthRequestModel
import com.chefsito.myownapp.auth.data.models.AuthResponseModel
import com.chefsito.myownapp.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun postAuth(username: String, password: String): AuthResponseModel {
        val response = authApi.login(
            AuthRequestModel(
                username = username,
                password = password
            )
        )
        if (!response.isSuccessful) {
            throw AuthDataException.FailException
        } else if (response.body() == null) {
            throw AuthDataException.BodyEmptyException
        }
        response.body()?.let {
            return it
        }
        throw AuthDataException.UnknowException
    }
}