package com.chefsito.myownapp.common.core

interface UseCase<Input,Ouput> {
    suspend fun exec(input: Input): Ouput
}