package com.example.movieapp.di

import android.content.Context
import com.example.movieapp.di.modules.AppModule
import com.example.movieapp.di.modules.CacheModule
import com.example.movieapp.di.modules.NetworkModule
import com.example.movieapp.main.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}