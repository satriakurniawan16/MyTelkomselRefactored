package com.example.mytelkomselrefactoredapp.data

import com.example.mytelkomselrefactoredapp.data.mapper.FaqMapper
import com.example.mytelkomselrefactoredapp.data.source.WCMSRemoteDataSourceFactory
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WCMSRepositoryImpl @Inject constructor(private val dataSourceFactory: WCMSRemoteDataSourceFactory,private val faqMapper: FaqMapper) : WCMSRepository{
    override suspend fun getAllTranslation(): Flow<String> = flow {
        emit(dataSourceFactory.getRemoteDataSource().getAllTranslation())
    }

    override suspend fun getFaq(): Flow<Faq> = flow {
        val resultFaq = dataSourceFactory.getRemoteDataSource().getFaq()
        emit(faqMapper.mapFromEntity(resultFaq))
    }


}