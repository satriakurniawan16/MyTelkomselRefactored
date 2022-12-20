package com.example.mytelkomselrefactoredapp.core.model

interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}
