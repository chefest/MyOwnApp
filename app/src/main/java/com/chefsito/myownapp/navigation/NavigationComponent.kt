package com.chefsito.myownapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chefsito.myownapp.auth.presentation.AuthScreen
import com.chefsito.myownapp.auth.presentation.AuthScreenViewModel
import com.chefsito.myownapp.common.core.ScreenStates
import com.chefsito.myownapp.dashboard.presentation.DashboardScreen
import com.chefsito.myownapp.dashboard.presentation.DashboardViewModel

@Composable
fun NavigationComponent(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            val authScreenViewModel: AuthScreenViewModel = hiltViewModel()
            val authScreenState by authScreenViewModel.state.collectAsState()

            LaunchedEffect(key1 = authScreenState) {
                if (ScreenStates.SUCCESS == authScreenState.screenStates) {
                    navController.navigate("dashboard")
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
        composable("dashboard") {
            val dashboardViewModel = viewModel<DashboardViewModel>()
            DashboardScreen()
        }
    }
}