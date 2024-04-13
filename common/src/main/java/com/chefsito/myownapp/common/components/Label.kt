package com.chefsito.myownapp.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Label(
    modifier: Modifier = Modifier,
    value: String = "",
    color: Color = Color.Black
){
    Text(
        modifier = modifier,
        text = value,
        color = color
    )
}