package com.sample.abridgeapp.network

sealed class ApiResponse<T> {

    companion object {
        fun <T> create(data: T) = ApiSuccessResponse(data)
        fun <T> create(throwable: Throwable) = ApiErrorResponse<T>(throwable.message ?: "Unknown Error")
    }
}

data class ApiErrorResponse<T>(val errorMessage: String) : ApiResponse<T>()

data class ApiSuccessResponse<T>(val data: T) : ApiResponse<T>()