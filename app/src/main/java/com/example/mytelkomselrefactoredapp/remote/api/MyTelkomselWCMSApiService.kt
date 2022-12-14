package com.example.mytelkomselrefactoredapp.remote.api

import com.example.mytelkomselrefactoredapp.remote.models.FaqResponseModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

interface MyTelkomselWCMSApiService {

    @GET("translation/all/mobile")
    suspend fun getAllTranslation(): String

    @GET("faq")
    suspend fun getFAQ(): FaqResponseModel

}