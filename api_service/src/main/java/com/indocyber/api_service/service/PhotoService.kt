package com.indocyber.api_service.service

import com.indocyber.common.data_class.PhotoResponse
import com.indocyber.common.data_class.PhotoResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoResponseItem>>
}