package com.example.mytelkomselrefactoredapp.di

import com.example.mytelkomselrefactoredapp.data.WCMSRepositoryImpl
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(wcmsRepository:  WCMSRepositoryImpl): WCMSRepository =
        wcmsRepository
}