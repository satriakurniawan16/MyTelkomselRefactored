package com.example.mytelkomselrefactoredapp.remote.repository

import com.example.mytelkomselrefactoredapp.data.repository.WCMSRemote
import com.example.mytelkomselrefactoredapp.remote.api.MyTelkomselWCMSApiService
import com.example.mytelkomselrefactoredapp.remote.models.FaqResponseModel
import javax.inject.Inject

class WCMSRemoteImp @Inject constructor(private val wcmsApiService: MyTelkomselWCMSApiService) : WCMSRemote{

    override suspend fun getAllTranslation(): String {
        return wcmsApiService.getAllTranslation()
    }

    override suspend fun getFaq(): FaqResponseModel {
        return wcmsApiService.getFAQ()
    }


}