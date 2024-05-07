package com.chefsito.myownapp.common.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MediaButtonUri(
    modifier: Modifier = Modifier,
    value: String = "",
    mediaType: String = "",
    onUriResult: (Uri)-> Unit
) {
    val rememberLauncher = rememberLauncherForActivityResult(
        contract =  ActivityResultContracts.GetContent()
    ) {
        it?.let(onUriResult)
    }
    Button(
        modifier = modifier,
        onClick =  {
            rememberLauncher.launch(mediaType)
        }
    ) {
        Label(value = value)
    }
}