package com.example.marvelapp.data

import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override suspend fun getCharacters() = networkDatasource.getMarvelCharacters()
    override suspend fun getCharacter(id: Long)=  networkDatasource.getMarvelCharacter(id)
}