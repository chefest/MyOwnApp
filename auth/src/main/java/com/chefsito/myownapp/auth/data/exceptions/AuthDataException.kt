package com.chefsito.myownapp.auth.data.exceptions

sealed class AuthDataException(): Exception() {
    constructor(message: String): this()
    object FailException: AuthDataException()
    object BodyEmptyException: AuthDataException()
    object UnknowException: AuthDataException()
}