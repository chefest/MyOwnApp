package com.chefsito.myownapp.common.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

typealias OnClickSubmit = ()-> Unit

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    value: String = "",
    onClickSubmit: OnClickSubmit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClickSubmit
    ) {
        Label(value = value)
    }
}