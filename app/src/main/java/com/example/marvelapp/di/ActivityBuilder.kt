package com.example.marvelapp.di


import com.example.marvelapp.presentation.detail.CharacterDetailActivity
import com.example.marvelapp.presentation.list.CharacterListActivity
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

    @ContributesAndroidInjector(modules = [CharacterDetailModule::class])
    fun bindFavoritetListActivity(): CharacterDetailActivity

}