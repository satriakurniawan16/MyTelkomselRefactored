package com.example.mytelkomselrefactoredapp.data.repository

import com.example.mytelkomselrefactoredapp.remote.models.FaqResponseModel

interface WCMSRemote {
    suspend fun getAllTranslation(): String
    suspend fun getFaq(): FaqResponseModel
}