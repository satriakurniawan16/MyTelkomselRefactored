package com.example.mytelkomselrefactoredapp.data.repository

import com.example.mytelkomselrefactoredapp.data.models.FaqEntity

interface WCMSRemote {
    suspend fun getAllTranslation(): String
    suspend fun getFaq(): FaqEntity
}