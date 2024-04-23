package com.chefsito.myownapp.auth.data.mappers

import com.chefsito.myownapp.auth.data.models.AuthResponseModel
import com.chefsito.myownapp.auth.domain.models.AuthDomainModel


fun AuthResponseModel.toAuthDomainModel(): AuthDomainModel {
    return AuthDomainModel(
        email = this.email,
        firstName = this.firstName,
        gender = this.gender,
        id = this.id,
        image = this.image,
        lastName = this.lastName,
        token = this.token,
        username = this.username
    )
}