package com.example.marvelapp.di

import com.example.marvelapp.data.ApiService
import dagger.Module
import dagger.Provides

@Module
object ProvidesModule {
    @Provides
    @JvmStatic
    fun providesApiService() = ApiService.create()
}