package com.chefsito.myownapp.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chefsito.myownapp.auth.domain.exceptions.AuthDomainException
import com.chefsito.myownapp.auth.domain.usecases.AuthUseCase
import com.chefsito.myownapp.common.core.ScreenStates
import com.chefsito.myownapp.common.core.token.TokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val tokenUseCase: TokenUseCase
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
        _state.update { current ->
            current.copy(username = value)
        }
    }

    fun onPasswordChanged(value: String) {
        _state.update { current ->
            current.copy(password = value)
        }
    }

    fun onSubmit() {
        login()
    }

    private fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = authUseCase.exec(
                    username = _state.value.username,
                    password = _state.value.password
                )
                tokenUseCase.exec(result.token)
                _state.update {
                    it.copy(screenStates = ScreenStates.SUCCESS)
                }
            } catch (ex: AuthDomainException) {
                _state.update {
                    it.copy(errorMessage = ex.message ?: "")
                }
            } catch (ex: Exception) {
                Log.d(this@AuthScreenViewModel::class.java.name, ex.message, ex)
            }
        }
    }
}