package com.example.data.movies.cache.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "movie_keys")
data class MovieRemoteKeys (
    @PrimaryKey
    val id : Int,
    val prevKey: Int?,
    val nextKey: Int?
)