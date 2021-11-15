package com.example.domain.movies.repository

import androidx.paging.PagingData
import com.example.domain.movies.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<PagingData<Movie>>
}