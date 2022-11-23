package com.example.mytelkomselrefactoredapp.data.source

import com.example.mytelkomselrefactoredapp.data.repository.WCMSDataSource
import com.example.mytelkomselrefactoredapp.data.repository.WCMSRemote
import javax.inject.Inject

class WCMSRemoteDataSource @Inject constructor(private val wcmsRemote: WCMSRemote) : WCMSDataSource{

    override suspend fun getAllTranslation(): String {
        return wcmsRemote.getAllTranslation()
    }

}