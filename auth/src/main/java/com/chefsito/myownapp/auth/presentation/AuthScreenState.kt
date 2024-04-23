package com.chefsito.myownapp.auth.presentation

import com.chefsito.myownapp.common.core.ScreenStates

data class AuthScreenState(
    val username: String = "kminchelle",
    val password: String = "0lelplR",
    val errorMessage: String = "",
    val screenStates: ScreenStates = ScreenStates.INIT
)