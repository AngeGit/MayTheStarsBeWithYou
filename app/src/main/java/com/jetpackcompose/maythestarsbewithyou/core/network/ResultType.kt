package com.jetpackcompose.maythestarsbewithyou.core.network

sealed class ResultType<T> {
    data class Success <T>(val data: T?):ResultType<T>()
    data class Error <T>(val errorMsg: String?):ResultType<T>()

}