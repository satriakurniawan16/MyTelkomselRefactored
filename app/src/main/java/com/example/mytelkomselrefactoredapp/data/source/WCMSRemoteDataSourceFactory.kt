package com.example.mytelkomselrefactoredapp.data.source

import javax.inject.Inject

open class WCMSRemoteDataSourceFactory @Inject constructor(
    private val remoteDataSource: WCMSRemoteDataSource
) {
    fun getRemoteDataSource(): WCMSRemoteDataSource{
        return remoteDataSource
    }
}