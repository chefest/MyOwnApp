package com.chefsito.myownapp.profile.domain.mappers

import com.chefsito.myownapp.profile.data.models.ProfileResponseModel
import com.chefsito.myownapp.profile.domain.models.ProfileDomainModel


fun ProfileResponseModel.toProfileDomainModel(): ProfileDomainModel {
    return ProfileDomainModel(
        email = this.email,
        firstName = this.firstName,
        gender = this.gender,
        height = this.height,
        id = this.id,
        image = this.image,
        lastName = this.lastName,
        phone = this.phone,
        username = this.username,
        weight = this.weight
    )
}