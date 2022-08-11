package com.indocyber.api_service.usecase

import android.util.Log
import com.indocyber.api_service.service.PhotoService
import com.indocyber.common.base.AppResponse
import com.indocyber.common.data_class.PhotoResponse
import com.indocyber.common.data_class.PhotoResponseItem
import kotlinx.coroutines.flow.flow

class PhotoUseCase(val photoService: PhotoService) {
    operator fun invoke() = flow<AppResponse<List<PhotoResponseItem>>> {
        try {
            emit(AppResponse.loading())
            val result = photoService.getPhotos()
            result.body()?.let {
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