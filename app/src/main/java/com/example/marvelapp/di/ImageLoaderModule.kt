package com.example.marvelapp.di


import com.example.marvelapp.domain.common.GlideImplementation
import com.example.marvelapp.domain.common.ImagesLoader
import dagger.Binds
import dagger.Module

@Module
interface ImageLoaderModule {
    @Binds
    fun bindImagesLoader(imagesLoader: GlideImplementation): ImagesLoader
}