package com.chefsito.myownapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chefsito.myownapp.navigation.routes.AppRoutes

@Composable
fun NavigationComponent(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.AuthRoute.route
    ) {
        navigateToAuthScreen(
            route = AppRoutes.AuthRoute.route,
            navController = navController
        )
        navigateToDashboardScreen(
            route = AppRoutes.DashboardRoute.route,
            navController = navController
        )
        navigateToProfile(
            route = AppRoutes.ProfileRoute.route,
            navController = navController
        )
    }
}