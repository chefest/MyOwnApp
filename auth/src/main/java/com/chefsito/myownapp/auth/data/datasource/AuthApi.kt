package com.chefsito.myownapp.auth.data.datasource

import com.chefsito.myownapp.auth.data.models.AuthRequestModel
import com.chefsito.myownapp.auth.data.models.AuthResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(LOGIN)
    suspend fun login(
        @Body authRequestModel: AuthRequestModel
    ): Response<AuthResponseModel>

    companion object {
        private const val LOGIN = "auth/login"
    }
}