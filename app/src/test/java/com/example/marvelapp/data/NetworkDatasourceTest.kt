package com.example.marvelapp.data

import com.example.marvelapp.*
import com.example.marvelapp.data.model.MarvelDataNetWorkResponse
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.Utilities
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString
import retrofit2.mock.Calls

class NetworkDatasourceTest {

    private lateinit var sut: NetworkDatasource
    private val apiService = mock<ApiService>()
    private val utilities = mock<Utilities>()

    private val timeStamp = 1000L
    private val hash = "anyHash"

    @Before
    fun setUp() {
        sut = NetworkDatasourceImpl(apiService, utilities)
        stubUtilitiesFunctions()
    }

    @Test
    fun `When get characters, should invoke proper apiService function`() {
        runBlocking {
            givenNetworkGetGroupListResponseOK(concreteNetworkModelResponse)

            sut.getMarvelCharacters()

            verify(apiService).getCharacterList(timeStamp, PUBLIC_KEY, hash)
        }
    }

    @Test
    fun `Given Success response, when get character list, then domain result success list model is returned`() {
        runBlocking {
            val expected = listOf(marvelCharacter, marvelCharacter, marvelCharacter)
            givenNetworkGetGroupListResponseOK(concreteNetworkModelResponse)

            val actual = sut.getMarvelCharacters()

            assertEquals(expected, (actual as ResultState.Success).data)
        }
    }

    @Test
    fun `Given Success response, when get OTHER character list, then domain result success list model is returned`() {
        runBlocking {
            val expected = listOf(otherMarvelCharacter, otherMarvelCharacter, otherMarvelCharacter)
            givenNetworkGetGroupListResponseOK(concreteOtherNetworkModel)

            val actual = sut.getMarvelCharacters()

            assertEquals(expected, (actual as ResultState.Success).data)
        }
    }


    @Test
    fun `Given Failure response, when get group list, then return Result failure`() {
        runBlocking {
            givenNetworkGetGroupListResponseKO()

            val result = sut.getMarvelCharacters()

            assert(result is ResultState.Error)
        }
    }

    private fun stubUtilitiesFunctions(){
        given(utilities.getTimeStamp()).willReturn(timeStamp)
        given(utilities.getHash()).willReturn(hash)
    }

    private fun givenNetworkGetGroupListResponseOK(responseData: MarvelDataNetWorkResponse) {
        given(
            apiService.getCharacterList(
                timeStamp = anyLong(),
                apikey = anyString(),
                hash = anyString()
            )
        ).willReturn(Calls.response(responseData))
    }


    private fun givenNetworkGetGroupListResponseKO() {
        given(apiService.getCharacterList(
            timeStamp = anyLong(),
            apikey = anyString(),
            hash = anyString()
        )).willReturn(Calls.failure(mock()))
    }
}