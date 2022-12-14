package com.example.mytelkomselrefactoredapp.domain.repository

import com.example.mytelkomselrefactoredapp.domain.models.Faq
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

interface WCMSRepository {
    suspend fun getAllTranslation(): Flow<String>
    suspend fun getFaq(): Flow<Faq>
}