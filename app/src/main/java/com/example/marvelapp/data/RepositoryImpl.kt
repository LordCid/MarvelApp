package com.example.marvelapp.data

import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override suspend fun getCharacters() = networkDatasource.getMarvelCharacters()
}