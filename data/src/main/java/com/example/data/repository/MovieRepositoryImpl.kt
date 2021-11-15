package com.example.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.movies.cache.Cache
import com.example.data.movies.network.Network
import com.example.data.movies.network.remote.source.MovieRemoteMediator
import com.example.domain.movies.model.Movie
import com.example.domain.movies.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val cache: Cache,
    private val network: Network
) : MovieRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = {
            cache.getAllMovies()
        }
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = MovieRemoteMediator(
                cache,
                network
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}