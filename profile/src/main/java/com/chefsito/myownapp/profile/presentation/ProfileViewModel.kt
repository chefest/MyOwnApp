package com.chefsito.myownapp.profile.presentation

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chefsito.myownapp.common.core.token.TokenUseCase
import com.chefsito.myownapp.profile.domain.exceptions.ProfileDomainException
import com.chefsito.myownapp.profile.domain.usecases.ProfileUseCase
import com.chefsito.myownapp.profile.presentation.models.ProfileModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase,
    private val tokenManager: TokenUseCase,
): ViewModel() {
    private val _profileStateScreenModel: MutableStateFlow<ProfileModelState> =
        MutableStateFlow(ProfileModelState())
    val profileStateScreenModel: StateFlow<ProfileModelState> = _profileStateScreenModel.asStateFlow()

    private val _errorState: MutableStateFlow<String> = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState.asStateFlow()

    @SuppressLint("ObsoleteSdkInt")
    fun onSelectImageEvent(uri: Uri) {
        _profileStateScreenModel.update {
            it.copy(uriImage = uri)
        }
    }

    fun getProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = profileUseCase.exec(tokenManager.getToken())
                _profileStateScreenModel.update {
                    it.copy(
                        name = result.firstName,
                        lastName = result.lastName,
                        email = result.email,
                        picture = result.image
                    )
                }
            } catch (ex: ProfileDomainException) {
                _errorState.update { ex.message ?: "" }
            } catch (ex: Exception) {
                Log.e(this@ProfileViewModel.javaClass.name, ex.message, ex)
            }
        }
    }
}