package com.example.mytelkomselrefactoredapp.core.model

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}