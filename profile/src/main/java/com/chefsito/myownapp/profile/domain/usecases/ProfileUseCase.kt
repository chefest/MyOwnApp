package com.chefsito.myownapp.profile.domain.usecases

import com.chefsito.myownapp.common.core.UseCase
import com.chefsito.myownapp.profile.data.exceptions.ProfileDataException
import com.chefsito.myownapp.profile.domain.exceptions.ProfileDomainException
import com.chefsito.myownapp.profile.domain.mappers.ToProfileDomainException
import com.chefsito.myownapp.profile.domain.mappers.toProfileDomainModel
import com.chefsito.myownapp.profile.domain.models.ProfileDomainModel
import com.chefsito.myownapp.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
): UseCase<String, ProfileDomainModel> {
    override suspend fun exec(input: String): ProfileDomainModel {
        if (input.isEmpty() || input.isBlank()) {
            throw ProfileDomainException.EmptyTokenException
        }
        try {
            return profileRepository.getProfile(token = input).toProfileDomainModel()
        } catch (ex: ProfileDataException) {
            throw ex.ToProfileDomainException()
        } catch (ex: Exception) {
            throw ex
        }
    }
}