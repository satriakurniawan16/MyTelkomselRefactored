package com.example.mytelkomselrefactoredapp.data.source

import javax.inject.Inject

open class WCMSRemoteDataSourceFactory @Inject constructor(
    private val remoteDataSource: WCMSRemoteDataSource,
    // local datasource resource
) {

//    if(cached){
//        get Local
//    }else{
//        get Remote
//    }


//    fun getLocalDatasource

    fun getRemoteDataSource(): WCMSRemoteDataSource{
        return remoteDataSource
    }
}