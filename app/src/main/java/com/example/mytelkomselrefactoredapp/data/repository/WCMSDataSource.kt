package com.example.mytelkomselrefactoredapp.data.repository

import com.example.mytelkomselrefactoredapp.data.models.FaqEntity

interface WCMSDataSource {

    // Remote
    suspend fun getAllTranslation(): String
    suspend fun getFaq(): FaqEntity

    // Cache

    // Remote and Cache


}