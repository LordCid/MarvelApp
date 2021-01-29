package com.example.marvelapp.data

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter

interface Repository {
    suspend fun getCharacters(): ResultState<List<MarvelCharacter>>
}