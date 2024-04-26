package com.chefsito.myownapp.navigation.routes

sealed class AppRoutes(val route: String) {
    object AuthRoute: AppRoutes("auth")
    object DashboardRoute: AppRoutes("dashboard")
    object ProfileRoute: AppRoutes("profile")

    sealed class AuthNavigation(val path: String) {
        object LoginPath: AuthNavigation("auth/login")
    }

    sealed class DashboardNavigation(val path: String) {
        object HomePath: DashboardNavigation("dashboard/home")
    }

    sealed class ProfileNavigation(val path: String) {
        object ProfilePath: ProfileNavigation("profile/me")
        object ProfileErrorDialog: ProfileNavigation("profile/error")
    }
}