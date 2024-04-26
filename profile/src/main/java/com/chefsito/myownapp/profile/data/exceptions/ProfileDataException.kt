package com.chefsito.myownapp.profile.data.exceptions

sealed class ProfileDataException(): Exception() {

    constructor(message: String) : this()

    object FailException : ProfileDataException()

    object BodyEmptyException : ProfileDataException()

    /**
     * This Error happen when the token is wrong
     */
    object InvalidSignature : ProfileDataException()

    /**
     * This Error happen when the token is Empty
     */
    object AuthenticationProblem : ProfileDataException()

    /**
     * This error happen when the token is expired
     */
    object TokenExpiredException : ProfileDataException()

    /**
     * Unknow Error
     */
    object UnknowException : ProfileDataException()
}
