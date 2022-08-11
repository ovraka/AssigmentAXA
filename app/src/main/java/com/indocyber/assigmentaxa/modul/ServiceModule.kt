package com.indocyber.assigmentaxa.modul

import android.app.Application
import com.indocyber.api_service.RetrofitClient
import com.indocyber.api_service.service.PhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    @Singleton
    fun provideRetrofirClien() = RetrofitClient.getClient()

    @Provides
    @Singleton
    fun providePhotoService(retrofit: Retrofit) = retrofit.create(PhotoService::class.java)
}