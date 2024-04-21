package com.chefsito.myownapp.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chefsito.myownapp.auth.domain.AuthDomainException
import com.chefsito.myownapp.auth.domain.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    val authUseCase: AuthUseCase
) : ViewModel() {

    /**
     * This variable will be used to write/read operations in the viewmodel
     */
    private val _state: MutableStateFlow<AuthScreenState> = MutableStateFlow(
        AuthScreenState()
    )

    /**
     * This variable will be used to read the information outside from viewmodel
     */
    val state: StateFlow<AuthScreenState> = _state.asStateFlow()

    fun onUsernameChanged(value: String) {
        _state.update { current->
            current.copy(username = value)
        }
    }

    fun onPasswordChanged(value: String) {
        _state.update { current->
            current.copy(password = value)
        }
    }
    fun onSubmit() {
        login()
    }

    private fun login() {
        try {
            authUseCase.exec(
                username = this._state.value.username,
                password = this._state.value.password
            )
        } catch (ex: Exception) {
            when (ex) {
                AuthDomainException.EmptyLoginFormException -> {
                    Log.e("error", ex.message, ex)
                }

                AuthDomainException.EmptyUserNameException -> {
                    Log.e("error", ex.message, ex)

                }

                AuthDomainException.EmptyPasswordException -> {
                    Log.e("error", ex.message, ex)
                }

                AuthDomainException.LengthPasswordException -> {
                    Log.e("error", ex.message, ex)
                }
            }
        }
    }
}