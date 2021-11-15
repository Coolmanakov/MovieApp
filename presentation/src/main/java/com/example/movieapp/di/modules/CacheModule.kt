package com.example.movieapp.di.modules

import android.content.Context
import com.example.data.movies.cache.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun provideCache(context: Context): MovieDatabase =
        MovieDatabase.getInstance(context)
}