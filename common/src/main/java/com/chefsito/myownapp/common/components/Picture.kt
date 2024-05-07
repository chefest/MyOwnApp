package com.chefsito.myownapp.common.components

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.chefsito.myownapp.common.R

@Composable
fun Piture(
    modifier: Modifier,
    url: String = "",
    contentDescription: String = stringResource(id = R.string.content_description)
) {
    AsyncImage(
        model = url,
        contentDescription = contentDescription,
        placeholder = painterResource(id = R.drawable.image_placeholder)
    )
}


@Composable
fun PitureFromUri(
    modifier: Modifier,
    uri: Uri? = null,
    contentDescription: String = stringResource(id = R.string.content_description)
) {
    AsyncImage(
        model = uri,
        contentDescription = contentDescription,
        placeholder = painterResource(id = R.drawable.image_placeholder)
    )
}