package com.chefsito.myownapp.common.core.utils


fun String.toBearerToken(): String {
    return "Bearer ".plus(this)
}