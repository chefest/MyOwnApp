package com.chefsito.myownapp.profile.domain.models

data class ProfileDomainModel(
    val email: String,
    val firstName: String,
    val gender: String,
    val height: Int,
    val id: Int,
    val image: String,
    val lastName: String,
    val phone: String,
    val username: String,
    val weight: Double
)