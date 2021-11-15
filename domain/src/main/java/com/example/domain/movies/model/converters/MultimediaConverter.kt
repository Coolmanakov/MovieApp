package com.example.domain.movies.model.converters

import androidx.room.TypeConverter
import com.example.domain.movies.model.Multimedia

class MultimediaConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromMultimedia(value: Multimedia): String =
            value.src

        @TypeConverter
        @JvmStatic
        fun toMultimedia(src: String): Multimedia =
            Multimedia(src)
    }
}