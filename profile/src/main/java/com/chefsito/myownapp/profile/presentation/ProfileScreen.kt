package com.chefsito.myownapp.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chefsito.myownapp.common.components.Label
import com.chefsito.myownapp.profile.presentation.models.ProfileModelState


@Composable
fun ProfileScreen(
    modifier: Modifier,
    profileScreenStateModel: ProfileModelState
){
    Column {
        Label(
            value = profileScreenStateModel.name
        )
        Label(
            value = profileScreenStateModel.email
        )
    }
}