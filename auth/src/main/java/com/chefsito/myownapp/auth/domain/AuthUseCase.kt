package com.chefsito.myownapp.auth.domain

import com.chefsito.myownapp.common.core.DomainException
import javax.inject.Inject

/**
 * This class hanlde all bussiness rules about
 * the login process
 */
class AuthUseCase @Inject constructor(
) {
    fun exec(
        username: String,
        password: String
    ){
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
        //TODO call login web service
    }
}