package com.example.marvelapp.di

import com.example.marvelapp.presentation.CharacterListActivity
import com.example.marvelapp.presentation.CharacterListContract
import com.example.marvelapp.presentation.CharactersListPresenter
import dagger.Binds
import dagger.Module

@Module
interface CharacterListModule {

    @Binds
    fun bindsCharacterListPresenter(presenter: CharactersListPresenter): CharacterListContract.Presenter

    @Binds
    fun bindsCharacterListView(activity: CharacterListActivity): CharacterListContract.View
}
