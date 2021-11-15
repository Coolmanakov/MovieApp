package com.example.data.movies.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<MovieRemoteKeys>)

    @Query("SELECT * FROM movie_keys WHERE id = :id")
    suspend fun remoteKeysByMovieId(id: Int): MovieRemoteKeys?

    @Query("DELETE FROM movie_keys")
    suspend fun clearRemoteKeys()
}