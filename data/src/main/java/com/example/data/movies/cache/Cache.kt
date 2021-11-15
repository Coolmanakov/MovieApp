package com.example.data.movies.cache

import com.example.data.movies.cache.db.MovieDatabase
import com.example.data.movies.cache.db.MovieRemoteKeys
import com.example.domain.movies.model.Movie
import javax.inject.Inject

class Cache @Inject constructor(
    val database: MovieDatabase
) {
    suspend fun insertAllMovies(movies: List<Movie>) = database.movieDao.insertAll(movies)
    fun getAllMovies() = database.movieDao.getAllMovies()
    suspend fun clearMovies() = database.movieDao.clearAll()
    suspend fun insertAllKeys(keys: List<MovieRemoteKeys>) = database.keysDao.insertAll(keys)
    suspend fun getKeysByMovieId(id: Int) = database.keysDao.remoteKeysByMovieId(id)
    suspend fun clearKeys() = database.keysDao.clearRemoteKeys()
}