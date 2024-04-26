package com.chefsito.myownapp.profile.domain.mappers

import com.chefsito.myownapp.profile.data.exceptions.ProfileDataException
import com.chefsito.myownapp.profile.domain.exceptions.ProfileDomainException

fun ProfileDataException.ToProfileDomainException(): ProfileDomainException{
    return when (this) {
        ProfileDataException.FailException-> ProfileDomainException.FailAPIException
        ProfileDataException.AuthenticationProblem -> ProfileDomainException.TokenAuthenticationException
        ProfileDataException.BodyEmptyException -> ProfileDomainException.NoBodyException
        ProfileDataException.InvalidSignature -> ProfileDomainException.TokenInvalidException
        ProfileDataException.TokenExpiredException -> ProfileDomainException.TokenExpiredException
        ProfileDataException.UnknowException -> ProfileDomainException.UnknownException
    }
}