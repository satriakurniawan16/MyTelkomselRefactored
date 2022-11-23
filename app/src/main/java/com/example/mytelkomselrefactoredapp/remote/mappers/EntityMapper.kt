package com.example.mytelkomselrefactoredapp.remote.mappers

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}