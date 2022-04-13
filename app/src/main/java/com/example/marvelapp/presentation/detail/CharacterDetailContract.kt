package com.example.marvelapp.presentation.detail

import com.example.marvelapp.domain.model.MarvelCharacter

interface CharacterDetailContract {
    interface View {
        fun showData(data: MarvelCharacter)
        fun showError()
    }

    interface Presenter {
        fun getCharacter(id: Long)
        fun onDestroy()
    }
}