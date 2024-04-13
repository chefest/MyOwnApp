package com.chefsito.myownapp.common.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Separator {
}

@Composable
fun Separator(
    modifier: Modifier = Modifier,
    value: Dp = 5.dp
) {
    Divider(
        modifier = modifier,
        thickness = value,
        color = Color.Transparent
    )
}