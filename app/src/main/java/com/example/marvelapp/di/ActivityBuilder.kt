package com.example.marvelapp.di


import com.example.marvelapp.presentation.CharacterListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        DomainModule::class,
        DataModule::class,
        ProvidesModule::class,
        ImageLoaderModule::class
    ]
)
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [CharacterListModule::class])
    fun bindMainListActivity(): CharacterListActivity
//
//    @ContributesAndroidInjector(modules = [FavoritesModule::class])
//    fun bindFavoritetListActivity(): FavoritesActivity


}