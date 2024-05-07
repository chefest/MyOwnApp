package com.chefsito.myownapp.navigation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chefsito.myownapp.navigation.routes.AppRoutes
import com.chefsito.myownapp.profile.presentation.ProfileScreen
import com.chefsito.myownapp.profile.presentation.ProfileViewModel

fun NavGraphBuilder.navigateToProfile(
    route: String,
    navController: NavController
) {
    navigation(
        route = route,
        startDestination = AppRoutes.ProfileNavigation.ProfilePath.path
    ) {
        composable(AppRoutes.ProfileNavigation.ProfilePath.path) {
            val profileViewmodel: ProfileViewModel = hiltViewModel()
            profileViewmodel.getProfile()
            val stateModel by profileViewmodel.profileStateScreenModel.collectAsState()
            val rememberLauncher = rememberLauncherForActivityResult(
                contract =  ActivityResultContracts.GetContent()
            ) { uri ->
                try {
                    uri?.let {
                        profileViewmodel.onSelectImageEvent(uri)
                    }
                } catch (ex: Exception) {
                    throw ex
                }
            }
            ProfileScreen(
                modifier = Modifier,
                profileScreenStateModel = stateModel,
                onClickSelectImage = {
                    rememberLauncher.launch("image/*")
                }
            )
        }
    }
}