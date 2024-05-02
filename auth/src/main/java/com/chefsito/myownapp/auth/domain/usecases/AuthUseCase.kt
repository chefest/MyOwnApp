package com.chefsito.myownapp.auth.domain.usecases

import com.chefsito.myownapp.auth.data.exceptions.AuthDataException
import com.chefsito.myownapp.auth.domain.utils.Constants
import com.chefsito.myownapp.auth.domain.exceptions.AuthDomainException
import com.chefsito.myownapp.auth.domain.models.AuthResponseDomainModel
import com.chefsito.myownapp.auth.domain.models.AuthRequestDomainModel
import com.chefsito.myownapp.auth.domain.repository.AuthRepository
import com.chefsito.myownapp.auth.domain.mappers.toAuthDomainException
import com.chefsito.myownapp.auth.domain.mappers.toAuthDomainModel
import com.chefsito.myownapp.common.core.UseCase
import javax.inject.Inject

/**
 * This class hanlde all bussiness rules about
 * the login process
 */
class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
): UseCase<AuthRequestDomainModel, AuthResponseDomainModel> {
    override suspend fun exec(
        input: AuthRequestDomainModel
    ): AuthResponseDomainModel {
        val username = input.username
        val password = input.password
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
            ).toAuthDomainModel()
        } catch (ex: AuthDataException) {
            throw ex.toAuthDomainException()
        } catch (ex: Exception) {
            throw AuthDomainException.UnknownException
        }
    }
}