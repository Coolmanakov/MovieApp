package com.example.movieapp.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/"

    @Volatile
    private var INSTANCE: Retrofit? = null

    fun <T> createService(service: Class<T>): T {
        return getInstance().create(service)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .client(buildHttpClient())
            .build()
    }

    private fun getInstance(): Retrofit {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: getRetrofit().also { INSTANCE = it }
        }
    }

    private fun buildHttpClient() = OkHttpClient.Builder()
        .addInterceptor(buildLogger())
        .build()

    private fun buildLogger() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)

    private fun buildGson() = GsonBuilder()
        .create()
}