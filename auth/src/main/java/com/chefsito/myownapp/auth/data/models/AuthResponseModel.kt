package com.chefsito.myownapp.auth.data.models

data class AuthResponseModel(
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val token: String,
    val username: String
)