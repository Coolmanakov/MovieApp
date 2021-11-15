package com.example.data.movies.network.remote.api

import com.example.data.BuildConfig
import com.example.data.movies.network.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("all.json")
    suspend fun getMovies(
        @Query("offset") page: Int,
        @Query("api-key") api_key: String = BuildConfig.API_TOKEN
    ): MovieResponse
}