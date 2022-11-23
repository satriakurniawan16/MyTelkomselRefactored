package com.example.mytelkomselrefactoredapp.remote.api

import com.example.mytelkomselrefactoredapp.remote.models.FaqResponseModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface MyTelkomselWCMSApiService {

    @GET("translation/all/mobile")
    suspend fun getAllTranslation(): String

    @GET("faq")
    suspend fun getFAQ(): FaqResponseModel

}