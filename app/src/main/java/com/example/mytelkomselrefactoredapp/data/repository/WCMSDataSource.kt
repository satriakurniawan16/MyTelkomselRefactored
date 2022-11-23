package com.example.mytelkomselrefactoredapp.data.repository

interface WCMSDataSource {

    // Remote
    suspend fun getAllTranslation(): String

    // Cache

    // Remote and Cache


}