package com.example.marvelapp.presentation

import com.example.marvelapp.domain.model.MarvelCharacter

interface CharacterListContract {
    interface View {
        fun showMarvelCharacters(data: List<MarvelCharacter> )
        fun showError()
    }

    interface Presenter {
        fun getCharacters()
    }
}