package com.example.domain.movies.interactors

import androidx.paging.PagingData
import com.example.domain.movies.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieInteractor {
    fun getMovie(): Flow<PagingData<Movie>>
}