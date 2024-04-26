package com.chefsito.myownapp.common.core.token

import com.chefsito.myownapp.common.core.DomainException
import com.chefsito.myownapp.common.core.UseCase

class TokenUseCase: UseCase<String, Unit> {
    private var token: String? = null
    override suspend fun exec(input: String): Unit {
        if (input.isEmpty() || input.isBlank()) {
            throw DomainException.EmptyException
        }
        token = input
    }

    fun getToken(): String{
        if(token == null) {
            throw DomainException.NullPointerException
        }
        return token as String
    }

}