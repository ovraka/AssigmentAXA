package com.indocyber.assigmentaxa.modul

import com.indocyber.api_service.service.PhotoService
import com.indocyber.api_service.usecase.PhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun providePhotoUseCase(photoService: PhotoService) = PhotoUseCase(photoService)
}