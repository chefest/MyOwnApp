package com.chefsito.myownapp.profile.presentation.models

import android.net.Uri

data class ProfileModelState(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val picture: String = "",
    val uriImage: Uri? = null
)