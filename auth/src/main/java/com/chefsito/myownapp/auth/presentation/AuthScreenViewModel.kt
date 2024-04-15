package com.chefsito.myownapp.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chefsito.myownapp.auth.domain.AuthDomainException
import com.chefsito.myownapp.auth.domain.AuthUseCase

class AuthScreenViewModel : ViewModel() {

    fun login(
        username: String,
        password: String,
    ) {
        try {
            val authUseCase: AuthUseCase = AuthUseCase()
            authUseCase.exec(
                username = username,
                password = password
            )
        } catch (ex: Exception) {
            when (ex) {
                AuthDomainException.EmptyLoginFormException -> {
                    Log.e("error",ex.message, ex)
                }

                AuthDomainException.EmptyUserNameException -> {
                    Log.e("error",ex.message, ex)

                }

                AuthDomainException.EmptyPasswordException -> {
                    Log.e("error",ex.message, ex)
                }

                AuthDomainException.LengthPasswordException -> {
                    Log.e("error",ex.message, ex)
                }
            }
        }
    }
}