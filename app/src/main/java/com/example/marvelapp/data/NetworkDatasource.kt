package com.example.marvelapp.data

import com.example.marvelapp.domain.model.MarvelCharacter

interface NetworkDatasource {
    suspend fun getCharacters(): Result<List<MarvelCharacter>>
}