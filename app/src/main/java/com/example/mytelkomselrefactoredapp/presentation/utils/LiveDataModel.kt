package com.example.mytelkomselrefactoredapp.presentation.utils

interface LiveDataModel

open class  LiveDataAwareModel: LiveDataModel{
    var isRedeliverd: Boolean = false
}