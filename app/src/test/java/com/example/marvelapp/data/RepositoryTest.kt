package com.example.marvelapp.data

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.marvelCharacter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryTest {

    private lateinit var sut: Repository
    private val networkDataSource = mock<NetworkDatasource>()

    @Before
    fun setUp() {
        sut = RepositoryImpl(networkDataSource)
    }

    @Test
    fun `Should invoke get character list in network data soruce and return its result`() {
        runBlocking {
            val expected = ResultState.Success(listOf(marvelCharacter))
            given(networkDataSource.getMarvelCharacters()).willReturn(expected)

            val actual = sut.getCharacters()

            verify(networkDataSource).getMarvelCharacters()
            assertEquals(expected, actual)
        }
    }

}