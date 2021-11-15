package com.example.data.movies.network

import com.example.data.movies.network.remote.api.MovieService
import javax.inject.Inject

class Network @Inject constructor(private val service: MovieService) {
    suspend fun getMovies(page: Int) = service.getMovies(page)
}