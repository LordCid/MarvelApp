package com.example.marvelapp.di

import com.example.marvelapp.presentation.list.CharacterListFragment
import com.example.marvelapp.presentation.list.CharacterListContract
import com.example.marvelapp.presentation.list.CharactersListPresenter
import dagger.Binds
import dagger.Module

@Module
interface CharacterListModule {

    @Binds
    fun bindsCharacterListPresenter(presenter: CharactersListPresenter): CharacterListContract.Presenter

    @Binds
    fun bindsCharacterListView(activity: CharacterListFragment): CharacterListContract.View
}
