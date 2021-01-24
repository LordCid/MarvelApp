package com.example.marvelapp.data

import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.domain.Utilities
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.domain.toDomain
import retrofit2.awaitResponse

class NetworkDatasourceImpl(
    private val apiService: ApiService,
    private val utilitiesImpl: Utilities
) : NetworkDatasource {
    override suspend fun getCharacters(): Result<List<MarvelCharacter>> {
        return runCatching {
            apiService.getCharacterList(
                timeStamp = utilitiesImpl.getTimeStamp(),
                apikey = PUBLIC_KEY,
                hash = utilitiesImpl.getHash()
            ).awaitResponse()
        }.fold(
            onSuccess = {
                val resultList = it.body()?.let { response ->
                    response.toDomain()
                }.orEmpty()
                Result.success(resultList)
            },
            onFailure = { Result.failure(it) }
        )
    }


}