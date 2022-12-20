package com.example.mytelkomselrefactoredapp.core.base

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}