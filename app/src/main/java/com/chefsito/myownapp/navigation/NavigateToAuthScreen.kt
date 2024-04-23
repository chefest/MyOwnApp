package com.chefsito.myownapp.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chefsito.myownapp.auth.presentation.AuthScreen
import com.chefsito.myownapp.auth.presentation.AuthScreenViewModel
import com.chefsito.myownapp.common.core.ScreenStates
import com.chefsito.myownapp.navigation.routes.AppRoutes


fun NavGraphBuilder.navigateToAuthScreen(
    navController: NavController,
    route: String
){
    navigation(
        startDestination = AppRoutes.AuthNavigation.LoginPath.path,
        route = route
    ) {
        composable(AppRoutes.AuthNavigation.LoginPath.path) {
            val authScreenViewModel: AuthScreenViewModel = hiltViewModel()
            val authScreenState by authScreenViewModel.state.collectAsState()
            LaunchedEffect(key1 = authScreenState) {
                if (ScreenStates.SUCCESS == authScreenState.screenStates) {
                    navController.navigate(AppRoutes.DashboardRoute.route)
                }
            }
            AuthScreen(
                modifier = Modifier,
                state = authScreenState,
                onUsernameChanged = authScreenViewModel::onUsernameChanged,
                onPasswordChanged = authScreenViewModel::onPasswordChanged,
                onClickSubmit = authScreenViewModel::onSubmit
            )
        }
    }
}