package com.example.marvelapp.di

import com.example.marvelapp.presentation.detail.CharacterDetailFragment
import com.example.marvelapp.presentation.detail.CharacterDetailContract
import com.example.marvelapp.presentation.detail.CharacterDetailPresenter
import dagger.Binds
import dagger.Module

@Module
interface CharacterDetailModule {

    @Binds
    fun bindsCharacterDetailresenter(presenter: CharacterDetailPresenter): CharacterDetailContract.Presenter

    @Binds
    fun bindsCharacterDetailView(activity: CharacterDetailFragment): CharacterDetailContract.View

}
