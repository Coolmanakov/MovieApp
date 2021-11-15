package com.example.movieapp.main.view

import androidx.paging.PagingData
import com.example.domain.movies.model.Movie
import com.example.domain.movies.interactors.MovieInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val movieInteractor: MovieInteractor){
    fun getAllMovies(): Flow<PagingData<Movie>> =
        movieInteractor.getMovie()
}