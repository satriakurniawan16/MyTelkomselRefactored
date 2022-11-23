package com.example.mytelkomselrefactoredapp.data

import com.example.mytelkomselrefactoredapp.data.source.WCMSRemoteDataSourceFactory
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WCMSRepositoryImpl @Inject constructor(private val dataSourceFactory: WCMSRemoteDataSourceFactory) : WCMSRepository{
    override suspend fun getAllTranslation(): Flow<String> = flow {
        emit(dataSourceFactory.getRemoteDataSource().getAllTranslation())
    }
}