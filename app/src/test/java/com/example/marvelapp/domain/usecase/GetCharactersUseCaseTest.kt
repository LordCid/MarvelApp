package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.Repository
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.marvelCharacter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetCharactersUseCaseTest {
    private lateinit var sut: GetCharactersUseCase
    private val repository = mock<Repository>()

    @Before
    fun setUp() {
        sut = GetCharactersUseCaseImpl(repository)
    }

    @Test
    fun `Should invoke get character list in network data soruce and return its result`() {
        runBlocking {
            val expected = ResultState.Success(listOf(marvelCharacter))
            given(repository.getCharacters()).willReturn(expected)

            val actual = sut.invoke()

            verify(repository).getCharacters()
            assertEquals(expected, actual)
        }
    }
}