package com.example.marvelapp.di

import com.example.marvelapp.presentation.detail.CharacterDetailActivity
import com.example.marvelapp.presentation.detail.CharacterDetailContract
import com.example.marvelapp.presentation.detail.CharacterDetailPresenter
import dagger.Binds
import dagger.Module

@Module
interface CharacterDetailModule {

    @Binds
    fun bindsCharacterDetailresenter(presenter: CharacterDetailPresenter): CharacterDetailContract.Presenter

    @Binds
    fun bindsCharacterDetailView(activity: CharacterDetailActivity): CharacterDetailContract.View

}
