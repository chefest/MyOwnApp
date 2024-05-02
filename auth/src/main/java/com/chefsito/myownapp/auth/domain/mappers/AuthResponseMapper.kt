package com.chefsito.myownapp.auth.domain.mappers

import com.chefsito.myownapp.auth.data.models.AuthResponseModel
import com.chefsito.myownapp.auth.domain.models.AuthResponseDomainModel


fun AuthResponseModel.toAuthDomainModel(): AuthResponseDomainModel {
    return AuthResponseDomainModel(
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