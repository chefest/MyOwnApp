package com.chefsito.myownapp.auth.domain.exceptions

import com.chefsito.myownapp.common.core.DomainException

sealed class AuthDomainException(override val message: String?): DomainException() {
    object EmptyLoginFormException: AuthDomainException("The username and password are empty")
    object EmptyUserNameException: AuthDomainException("The username is empty")
    object EmptyPasswordException: AuthDomainException("The password is empty")
    object LengthPasswordException: AuthDomainException("The length of password is not correct")
    object FailAPIException: AuthDomainException("There was an error calling the auth api")
    object NoBodyException: AuthDomainException("The response from the server is empty")
    object UnknownException: AuthDomainException("Unkown exception")



}