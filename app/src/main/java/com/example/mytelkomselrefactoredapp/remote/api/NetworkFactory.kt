package com.example.mytelkomselrefactoredapp.remote.api

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.mytelkomselrefactoredapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

object NetworkFactory {

    fun createBuilder(context : Context):OkHttpClient.Builder{
        val builder = OkHttpClient.Builder()
//        builder.addInterceptor(DiffieHellmanInterceptor())

        val flavor: String = BuildConfig.FLAVOR
        val buildType: String = BuildConfig.BUILD_TYPE
        val useChuck = flavor != "production" || buildType == "debug"
        if (!useChuck) return builder

        val chuckerInterceptor: ChuckerInterceptor = ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()

        builder.addInterceptor(chuckerInterceptor)

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(interceptor)
        return  builder

    }

}