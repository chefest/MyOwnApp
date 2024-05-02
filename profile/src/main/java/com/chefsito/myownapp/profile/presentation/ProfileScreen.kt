package com.chefsito.myownapp.profile.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chefsito.myownapp.common.components.Label
import com.chefsito.myownapp.profile.presentation.models.ProfileModelState
import com.chefsito.myownapp.common.components.Piture
import com.chefsito.myownapp.profile.R

@Composable
fun ProfileScreen(
    modifier: Modifier,
    profileScreenStateModel: ProfileModelState
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Piture(
            modifier = modifier,
            url = profileScreenStateModel.picture
        )
        Record(
            label = stringResource(id = R.string.name),
            value = profileScreenStateModel.name
        )
        Record(
            label = stringResource(id = R.string.lastname),
            value = profileScreenStateModel.lastName
        )
        Record(
            label = stringResource(id = R.string.email),
            value = profileScreenStateModel.email
        )
    }
}

@Composable
private fun Record(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .border(BorderStroke(1.dp, SolidColor(Color.LightGray)))
    ) {
        Label(
            modifier = Modifier.weight(.3f).padding(5.dp),
            value = label,
            color = Color.DarkGray
        )
        Label(
            modifier = Modifier.weight(.7f).padding(5.dp),
            value = value,
            color = Color.Blue
        )
    }
}