package com.example.marvelapp.di


import com.example.marvelapp.presentation.detail.CharacterDetailFragment
import com.example.marvelapp.presentation.list.CharacterListFragment
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
    fun bindMainListActivity(): CharacterListFragment

    @ContributesAndroidInjector(modules = [CharacterDetailModule::class])
    fun bindFavoritetListActivity(): CharacterDetailFragment

}