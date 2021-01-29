package com.example.marvelapp.di

import com.example.marvelapp.presentation.list.CharacterListActivity
import com.example.marvelapp.presentation.list.CharacterListContract
import com.example.marvelapp.presentation.list.CharactersListPresenter
import dagger.Binds
import dagger.Module

@Module
interface CharacterListModule {

    @Binds
    fun bindsCharacterListPresenter(presenter: CharactersListPresenter): CharacterListContract.Presenter

    @Binds
    fun bindsCharacterListView(activity: CharacterListActivity): CharacterListContract.View
}
