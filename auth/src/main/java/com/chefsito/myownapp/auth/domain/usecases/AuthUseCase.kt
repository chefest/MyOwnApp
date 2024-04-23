package com.chefsito.myownapp.auth.domain.usecases

import com.chefsito.myownapp.auth.data.exceptions.AuthDataException
import com.chefsito.myownapp.auth.domain.utils.Constants
import com.chefsito.myownapp.auth.domain.exceptions.AuthDomainException
import com.chefsito.myownapp.auth.domain.models.AuthDomainModel
import com.chefsito.myownapp.auth.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * This class hanlde all bussiness rules about
 * the login process
 */
class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun exec(
        username: String,
        password: String
    ): AuthDomainModel {
        if (username.isEmpty() && password.isEmpty()) {
            throw AuthDomainException.EmptyLoginFormException
        }
        if (username.isEmpty()) {
            throw AuthDomainException.EmptyUserNameException
        }
        if (password.isEmpty()) {
            throw AuthDomainException.EmptyPasswordException
        }
        if (password.length < Constants.PASSWORD_MINIMUM_LENGTH) {
            throw AuthDomainException.LengthPasswordException
        }
        try {
             return authRepository.postAuth(
                username = username,
                password = password
            )
        } catch (ex: Exception) {
            when(ex) {
                AuthDataException.BodyEmptyException->{
                    throw AuthDomainException.FailAPIException
                }
                AuthDataException.FailException->{
                    throw AuthDomainException.NoBodyException
                }
                AuthDataException.UnknowException->{
                    throw AuthDomainException.UnknownException
                }
            }
        }
        throw AuthDomainException.UnknownException
    }
}