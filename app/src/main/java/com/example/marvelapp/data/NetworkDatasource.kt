package com.example.marvelapp.data

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter

interface NetworkDatasource {
    suspend fun getMarvelCharacters(): ResultState<List<MarvelCharacter>>
}