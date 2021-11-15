package com.example.movieapp.di.modules

import com.example.data.movies.network.remote.api.MovieService
import com.example.movieapp.retrofit.RetrofitUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideMovieService(): MovieService =
        RetrofitUtils.createService(MovieService::class.java)
}