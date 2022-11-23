package com.example.mytelkomselrefactoredapp.presentation.viewmodel

import com.example.mytelkomselrefactoredapp.presentation.utils.LiveDataAwareModel

sealed class StatefulResult<out T> : LiveDataAwareModel() {
    val succeeded
        get() = this is Success && data != null

    data class Success<out T>(val data: T) : StatefulResult<T>()
    data class Failed(var error: String = "") : StatefulResult<Nothing>()
    object Loading : StatefulResult<Nothing>()
}