package com.example.mytelkomselrefactoredapp.di

import android.content.Context
import com.example.mytelkomselrefactoredapp.BuildConfig
//import com.example.mytelkomselrefactoredapp.core.network.MyTelkomselAuthenticator
import com.example.mytelkomselrefactoredapp.data.repository.WCMSRemote
import com.example.mytelkomselrefactoredapp.remote.api.MyTelkomselWCMSApiService
import com.example.mytelkomselrefactoredapp.remote.api.ServiceFactory
import com.example.mytelkomselrefactoredapp.remote.repository.WCMSRemoteImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
//    @Provides
//    @Singleton
//    fun provideMyTelkomselAuthenticator(@ApplicationContext context: Context) : MyTelkomselAuthenticator {
//        return MyTelkomselAuthenticator(context)
//    }

    @Provides
    @Singleton
    fun ProvideWCMSService(@ApplicationContext context: Context) : MyTelkomselWCMSApiService {
        return ServiceFactory.create(BuildConfig.WCMS_BASE_URL,context)
    }

    @Provides
    @Singleton
    fun provideWCMSRemote(wcmsRemote: WCMSRemoteImp) : WCMSRemote{
        return wcmsRemote
    }
}