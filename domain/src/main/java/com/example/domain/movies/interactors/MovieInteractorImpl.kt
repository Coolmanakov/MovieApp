package com.example.domain.movies.interactors

import androidx.paging.PagingData
import com.example.domain.movies.model.Movie
import com.example.domain.movies.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractorImpl @Inject constructor(
    private val repository: MovieRepository
) : MovieInteractor {
    override fun getMovie(): Flow<PagingData<Movie>> =
        repository.getMovies()
}