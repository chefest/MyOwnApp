package com.chefsito.myownapp.auth.presentation

import com.chefsito.myownapp.common.core.ScreenStates

data class AuthScreenState(
    val username: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val screenStates: ScreenStates = ScreenStates.INIT
)