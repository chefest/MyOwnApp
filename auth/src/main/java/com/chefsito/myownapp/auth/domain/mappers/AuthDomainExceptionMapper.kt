package com.chefsito.myownapp.auth.domain.mappers

import com.chefsito.myownapp.auth.data.exceptions.AuthDataException
import com.chefsito.myownapp.auth.domain.exceptions.AuthDomainException


fun AuthDataException.toAuthDomainException(): AuthDomainException {
    return when (this) {
        AuthDataException.BodyEmptyException -> AuthDomainException.FailAPIException
        AuthDataException.FailException -> AuthDomainException.NoBodyException
        AuthDataException.UnknowException -> AuthDomainException.UnknownException
    }
}