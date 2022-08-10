package com.indocyber.common.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

object Constants {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun ImageView.loadImageFromUrl(url: String) {
        Glide.with(this).load(url).into(this)
    }
}