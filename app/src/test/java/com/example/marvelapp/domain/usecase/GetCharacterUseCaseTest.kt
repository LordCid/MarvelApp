package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.Repository
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.marvelCharacter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong

class GetCharacterUseCaseTest {
    private lateinit var sut: GetCharacterUseCase
    private val repository = mock<Repository>()

    @Before
    fun setUp() {
        sut = GetCharacterUseCaseImpl(repository)
    }

    @Test
    fun `Should invoke get character list in network data soruce and return its result`() {
        runBlocking {
            val someId = 1234L
            val expected = ResultState.Success(marvelCharacter)
            given(repository.getCharacter(anyLong())).willReturn(expected)

            val actual = sut.invoke(someId)

            verify(repository).getCharacter(someId)
            Assert.assertEquals(expected, actual)
        }
    }
}