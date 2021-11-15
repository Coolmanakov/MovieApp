package com.example.movieapp.di.modules

import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.movies.interactors.MovieInteractor
import com.example.domain.movies.interactors.MovieInteractorImpl
import com.example.domain.movies.repository.MovieRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {
    @Singleton
    @Binds
    fun createMovieInteractor(interactorImpl: MovieInteractorImpl): MovieInteractor

    @Singleton
    @Binds
    fun createMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}