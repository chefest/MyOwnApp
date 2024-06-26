package com.chefsito.myownapp.auth.domain.models

data class AuthResponseDomainModel(
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val token: String,
    val username: String
)