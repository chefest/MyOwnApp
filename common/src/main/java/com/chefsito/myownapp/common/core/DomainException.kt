package com.chefsito.myownapp.common.core

open class DomainException: Exception() {
    object NullPointerException: DomainException()
    object EmptyException: DomainException()
    object TimeOutException: DomainException()
    object UnknownException: DomainException()
}