package com.indocyber.common.data_class


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("photoResponseItem")
    val photoResponseItem: List<PhotoResponseItem>
)