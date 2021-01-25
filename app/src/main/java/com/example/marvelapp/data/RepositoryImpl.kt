package com.example.marvelapp.data

import com.example.marvelapp.domain.model.MarvelCharacter

class RepositoryImpl(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override suspend fun getCharacters(): Result<List<MarvelCharacter>> {
        return networkDatasource.getCharacters()
    }
}