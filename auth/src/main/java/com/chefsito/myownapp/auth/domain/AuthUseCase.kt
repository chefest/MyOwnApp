package com.chefsito.myownapp.auth.domain

/**
 * This class hanlde all bussiness rules about
 * the login process
 */
class AuthUseCase {
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