package com.example.mytelkomselrefactoredapp.data.repository

import com.example.mytelkomselrefactoredapp.data.models.FaqEntity

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

interface WCMSDataSource {

    // Remote
    suspend fun getAllTranslation(): String
    suspend fun getFaq(): FaqEntity

    // Cache

    // Remote and Cache


}