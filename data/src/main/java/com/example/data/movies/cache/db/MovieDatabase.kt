package com.example.data.movies.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.movies.model.Movie
import com.example.domain.movies.model.Multimedia
import com.example.domain.movies.model.converters.MultimediaConverter

@Database(
    entities = [
        Movie::class,
        MovieRemoteKeys::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(value = [MultimediaConverter::class])
abstract class MovieDatabase : RoomDatabase(){
    abstract val movieDao: MovieDao
    abstract val keysDao: MovieKeysDao
    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java, "Movie.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}