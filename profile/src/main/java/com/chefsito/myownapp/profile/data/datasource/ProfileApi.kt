package com.chefsito.myownapp.profile.data.datasource

import com.chefsito.myownapp.profile.data.models.ProfileResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {

    @GET(GET_PROFILE)
    suspend fun getProfile(
        @Header("Authorization") token: String
    ): Response<ProfileResponseModel>

    companion object {
        private const val GET_PROFILE = "auth/me"
    }
}