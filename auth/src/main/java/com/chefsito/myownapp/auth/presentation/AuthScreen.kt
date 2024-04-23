package com.chefsito.myownapp.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.chefsito.myownapp.common.components.Label
import com.chefsito.myownapp.common.components.OnClickSubmit
import com.chefsito.myownapp.common.components.OnValueChange


@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    state: AuthScreenState = AuthScreenState(),
    onUsernameChanged: OnValueChange = {},
    onPasswordChanged: OnValueChange = {},
    onClickSubmit: OnClickSubmit = {}
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
            value = state.username,
            label = stringResource(id = R.string.username_email),
            onValueChange = onUsernameChanged
        )
        InputText(
            modifier = modifier.fillMaxWidth(),
            value = state.password,
            label = stringResource(id = R.string.password),
            onValueChange = onPasswordChanged,
            isPassword = true
        )
        Separator(value = 10.dp)
        Label(
            value = state.errorMessage,
            color = Color.Red
        )
        Separator(value = 10.dp)
        SubmitButton(
            modifier = modifier.fillMaxWidth(),
            value = "Enter",
            onClickSubmit = onClickSubmit
        )
    }
}