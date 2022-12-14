package com.example.mytelkomselrefactoredapp.di

import com.example.mytelkomselrefactoredapp.data.WCMSRepositoryImpl
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(wcmsRepository:  WCMSRepositoryImpl): WCMSRepository =
        wcmsRepository
}