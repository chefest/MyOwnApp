package com.chefsito.myownapp.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chefsito.myownapp.common.components.InputText
import com.chefsito.myownapp.common.components.Separator
import com.chefsito.myownapp.common.components.SubmitButton
import com.chefsito.myownapp.auth.R


@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputText(
            modifier = modifier.fillMaxWidth(),
            value = "",
            label = stringResource(id = R.string.username_email),
            onValueChange = {
                println("on value change")
            }
        )
        InputText(
            modifier = modifier.fillMaxWidth(),
            value = "",
            label = stringResource(id = R.string.password),
            onValueChange = {
                println("on value change")
            },
            isPassword = true
        )
        Separator(value = 10.dp)
        SubmitButton(
            modifier = modifier.fillMaxWidth(),
            value = "Enter",
            onClickSubmit = {
                println("Enter clicked")
            }
        )
    }
}