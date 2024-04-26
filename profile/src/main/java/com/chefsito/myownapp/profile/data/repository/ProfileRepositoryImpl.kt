package com.chefsito.myownapp.profile.data.repository

import com.chefsito.myownapp.profile.data.datasource.ProfileApi
import com.chefsito.myownapp.profile.data.exceptions.ProfileDataException
import com.chefsito.myownapp.profile.data.models.ProfileResponseModel
import com.chefsito.myownapp.profile.domain.repository.ProfileRepository
import com.chefsito.myownapp.common.core.utils.toBearerToken
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApi: ProfileApi
): ProfileRepository {
    override suspend fun getProfile(token: String): ProfileResponseModel {
        val response = profileApi.getProfile(token.toBearerToken())
        if (response.code() == 403) {
            throw ProfileDataException.AuthenticationProblem
        } else if (response.code() == 500) {
            throw ProfileDataException.InvalidSignature
        } else if (response.code() == 401) {
            throw ProfileDataException.TokenExpiredException
        }
        if (!response.isSuccessful) {
            throw ProfileDataException.FailException
        }
        if (response.body() == null) {
            throw ProfileDataException.BodyEmptyException
        }
        response.body()?.let {
            return it
        }
        throw ProfileDataException.UnknowException
    }
}