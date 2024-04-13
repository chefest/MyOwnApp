package com.chefsito.myownapp.common.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

typealias OnValueChange = (String)-> Unit

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    isPassword: Boolean = false,
    onValueChange: OnValueChange = {}
) {
    var text by remember {
        mutableStateOf(value)
    }
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onValueChange.invoke(it)
        },
        label = {
            Label(value = label)
        },
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}

