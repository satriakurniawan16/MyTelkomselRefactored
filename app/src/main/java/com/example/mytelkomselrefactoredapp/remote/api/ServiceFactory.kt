package com.example.mytelkomselrefactoredapp.remote.api

import android.content.Context
import com.example.mytelkomselrefactoredapp.BuildConfig
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

object ServiceFactory {

    fun create(baseUrl : String,context: Context): MyTelkomselWCMSApiService {
        val retrofit = createRetrofit("https://tdwstcontent.telkomsel.com/api/",context)
        return retrofit.create(MyTelkomselWCMSApiService::class.java)
    }

    private fun createRetrofit(baseUrl: String,context: Context) : Retrofit{

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createOkHttpClient(context))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun createOkHttpClient(context: Context): OkHttpClient {
        val builder = NetworkFactory.createBuilder(context)
        builder.readTimeout(BuildConfig.BASE_READTIMEOUT.toInt().toLong(), TimeUnit.MILLISECONDS)
        builder.connectTimeout(BuildConfig.BASE_CONNECTIONTIMEOUT.toInt().toLong(),TimeUnit.MILLISECONDS)
        builder.writeTimeout(BuildConfig.BASE_WRITETIMEOUT.toInt().toLong(), TimeUnit.MILLISECONDS)

        val connectionPool = ConnectionPool(5, 10, TimeUnit.MINUTES)
        builder.connectionPool(connectionPool)

        builder.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
            requestBuilder.header("Origin", BuildConfig.HEADER_ORIGIN_VALUE)
            requestBuilder.header("CHANNELID", BuildConfig.HEADER_CHANNELID_VALUE)
            requestBuilder.header("MYTELKOMSEL-MOBILE-APP-VERSION", BuildConfig.APP_VERSION)
            requestBuilder.header("X-REQUESTED-WITH", BuildConfig.HEADER_X_REQUESTED_VALUE)
            requestBuilder.header("Content-Type", "application/json")
            requestBuilder.method(original.method, original.body)
            chain.proceed(requestBuilder.build())
        })
        return builder.build()
    }

}