package com.example.marvelapp.data

import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.Utilities
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.domain.toDomain
import retrofit2.awaitResponse
import javax.inject.Inject
import kotlin.Result.Companion.failure

class NetworkDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val utilitiesImpl: Utilities
) : NetworkDatasource {
    override suspend fun getMarvelCharacters(): ResultState<List<MarvelCharacter>> {
        return runCatching {
            apiService.getCharacterList(
                timeStamp = utilitiesImpl.getTimeStamp(),
                apikey = PUBLIC_KEY,
                hash = utilitiesImpl.getHash()
            ).awaitResponse()
        }.fold(
            onSuccess = {
                val resultList = it.body()?.toDomain().orEmpty()
                ResultState.Success(resultList)
            },
            onFailure = { ResultState.Error }
        )
    }

    override suspend fun getMarvelCharacter(id: Long): ResultState<MarvelCharacter> {
        return runCatching {
            apiService.getCharacter(
                timeStamp = utilitiesImpl.getTimeStamp(),
                apikey = PUBLIC_KEY,
                hash = utilitiesImpl.getHash(),
                id = id
            ).awaitResponse()
        }.fold(
            onSuccess = {
                val response = it.body()
                if (response != null) {
                    val result = response.toDomain()
                    ResultState.Success(result)
                } else {
                    ResultState.Error
                }
            },
            onFailure = { ResultState.Error }
        )
    }


}