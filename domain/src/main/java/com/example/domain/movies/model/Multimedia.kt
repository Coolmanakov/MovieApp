package com.example.domain.movies.model

import android.os.Parcelable
import androidx.room.Ignore
import kotlinx.parcelize.Parcelize

@Parcelize
data class Multimedia(
    val src: String,
    //here we need only image
    @Ignore val height: Int = 0,
    @Ignore val type: String = "",
    @Ignore val width: Int = 0
) : Parcelable