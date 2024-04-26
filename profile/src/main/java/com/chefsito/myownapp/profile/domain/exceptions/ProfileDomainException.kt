package com.chefsito.myownapp.profile.domain.exceptions

import com.chefsito.myownapp.common.core.DomainException

sealed class ProfileDomainException(override val message: String?): DomainException() {
    object TokenAuthenticationException: ProfileDomainException("There was an error with" +
            " the authentication token")
    object EmptyTokenException: ProfileDomainException("Token is empty")
    object TokenExpiredException: ProfileDomainException("The token has expired")
    object FailAPIException: ProfileDomainException("There was an error calling the auth api")
    object NoBodyException: ProfileDomainException("The response from the server is empty")
    object UnknownException: ProfileDomainException("There was an unknown exception")
    object TokenInvalidException: ProfileDomainException("The token is not valid")
}