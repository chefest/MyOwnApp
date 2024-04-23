package com.chefsito.myownapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chefsito.myownapp.dashboard.presentation.DashboardScreen
import com.chefsito.myownapp.dashboard.presentation.DashboardViewModel
import com.chefsito.myownapp.navigation.routes.AppRoutes

fun NavGraphBuilder.navigateToDashboardScreen(
    route: String,
    navController: NavController
) {
    navigation(
        startDestination = AppRoutes.DashboardNavigation.HomePath.path,
        route = route,
    ) {
        composable(AppRoutes.DashboardNavigation.HomePath.path) {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            DashboardScreen()
        }
    }
}