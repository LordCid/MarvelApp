package com.example.marvelapp.data

class RepositoryImpl(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override suspend fun getCharacters() = networkDatasource.getMarvelCharacters()
}