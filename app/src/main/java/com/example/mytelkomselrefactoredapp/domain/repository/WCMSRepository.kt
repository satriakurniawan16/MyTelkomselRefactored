package com.example.mytelkomselrefactoredapp.domain.repository

import com.example.mytelkomselrefactoredapp.domain.models.Faq
import kotlinx.coroutines.flow.Flow

interface WCMSRepository {
    suspend fun getAllTranslation(): Flow<String>
    suspend fun getFaq(): Flow<Faq>
}