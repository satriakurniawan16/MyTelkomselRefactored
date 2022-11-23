package com.example.mytelkomselrefactoredapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface WCMSRepository {
    suspend fun getAllTranslation(): Flow<String>
}