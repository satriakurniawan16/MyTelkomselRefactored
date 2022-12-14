package com.example.mytelkomselrefactoredapp.di

import com.example.mytelkomselrefactoredapp.presentation.utils.CoroutineContextProvider
import com.example.mytelkomselrefactoredapp.presentation.utils.CoroutineContextProviderImp
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
object PresentationModule {
    @Provides
    @Singleton
    fun provideCoroutineContextProvider(contextProvider: CoroutineContextProviderImp): CoroutineContextProvider =
        contextProvider
}