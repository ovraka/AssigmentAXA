package com.indocyber.assigmentaxa.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.indocyber.api_service.usecase.PhotoUseCase
import com.indocyber.common.base.AppResponse
import com.indocyber.common.data_class.PhotoResponse
import com.indocyber.common.data_class.PhotoResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(application: Application, val photoUseCase: PhotoUseCase) :
    AndroidViewModel(application) {
    val searchData = MutableLiveData<String>()
    val photoData = MutableLiveData<AppResponse<List<PhotoResponseItem>>>()

    init {
        getPhoto()
    }

    fun getPhoto() {
        Log.i("No Data", "Kepanggil")
        viewModelScope.launch {
            Log.i("No Data", "baru get data")
            photoUseCase.invoke().collect {
                photoData.postValue(it)
            }
        }
    }

    fun filter(search: String): List<PhotoResponseItem> = photoData.value?.let {
        if (it is AppResponse.AppResponseSuccess) {
            it.data?.filter {
                it.title.contains(search, true)
            }
        } else {
            arrayListOf()
        }
    } ?: run {
        arrayListOf()
    }
}