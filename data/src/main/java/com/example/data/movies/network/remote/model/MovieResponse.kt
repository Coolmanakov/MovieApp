package com.example.data.movies.network.remote.model

import com.example.domain.movies.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val status: String,
    val copyright: String,
    @field:SerializedName ("has_more") val endOfPaginationNotReached: Boolean,
    val num_results: Int,
    @field:SerializedName("results") val movies: List<Movie>
)