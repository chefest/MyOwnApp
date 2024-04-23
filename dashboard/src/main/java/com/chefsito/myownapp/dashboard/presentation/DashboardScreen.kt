package com.chefsito.myownapp.dashboard.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chefsito.myownapp.common.components.Label

@Composable

fun DashboardScreen(
    modifier: Modifier = Modifier
){
    Label(
        value = "Bienvenido al dashboard"
    )
}