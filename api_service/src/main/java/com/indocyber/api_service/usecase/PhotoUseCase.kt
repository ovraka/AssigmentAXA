package com.indocyber.api_service.usecase

import com.indocyber.api_service.service.PhotoService
import com.indocyber.common.base.AppResponse
import com.indocyber.common.data_class.PhotoResponse
import kotlinx.coroutines.flow.flow

class PhotoUseCase(val photoService: PhotoService) {
    operator fun invoke() = flow<AppResponse<PhotoResponse>> {
        try {
            emit(AppResponse.loading())
            val data = photoService.getPhotos()
            data.body()?.let {
                emit(AppResponse.success(it))
            }
                ?: run {
                    emit(AppResponse.failure(Exception("Null Data")))
                }
        } catch (e: Exception) {
            emit(AppResponse.failure(e))
        }
    }
}