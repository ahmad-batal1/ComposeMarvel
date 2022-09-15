package com.example.composemarvel.util

sealed class State<out T> {
    data class Success<T>(val data: T?) : State<T>()
    data class Fail<T>(val message: String) : State<T>()
    object Loading : State<Nothing>()

    fun toData(): T? = if (this is Success) data else null
}
