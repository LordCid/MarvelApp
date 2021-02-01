package com.example.marvelapp.presentation.detail

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.getCharactertById
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong

class CharacterDetailPresenterTest {

    private lateinit var sut: CharacterDetailContract.Presenter
    private val view = mock<CharacterDetailContract.View>()
    private val getCharacterUseCase = mock<GetCharacterUseCase>()

    @ExperimentalCoroutinesApi
    private var dispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        sut = CharacterDetailPresenter(view, getCharacterUseCase, dispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }


    @Test
    fun `Given product Id, should get product and show it in UI`() {
        runBlocking {
            val someId = 1234L
            val expectedCharacter = getCharactertById(someId)
            givenSuccesResults(expectedCharacter)

            sut.getCharacter(someId)

            val inOrder = inOrder(getCharacterUseCase, view)
            inOrder.verify(getCharacterUseCase).invoke(someId)
            inOrder.verify(view).showData(expectedCharacter)
        }
    }

    @Test
    fun `Given OTHER product Id, should get product and show it in UI`() {
        runBlocking {
            val someId = 4567L
            val expectedCharacter = getCharactertById(someId)
            givenSuccesResults(expectedCharacter)

            sut.getCharacter(someId)

            val inOrder = inOrder(getCharacterUseCase, view)
            inOrder.verify(getCharacterUseCase).invoke(someId)
            inOrder.verify(view).showData(expectedCharacter)
        }
    }


    @Test
    fun `Given failure when getting product list, error is shown in the UI`() {
        runBlocking {
            val someId = 1234L
            givenFailureResult()

            sut.getCharacter(someId)

            val inOrder = inOrder(getCharacterUseCase, view)
            inOrder.verify(getCharacterUseCase).invoke(someId)
            inOrder.verify(view).showError()
        }
    }

    private suspend fun givenSuccesResults(character: MarvelCharacter) {
        given(getCharacterUseCase.invoke(anyLong())).willReturn(ResultState.Success(character))
    }

    private suspend fun givenFailureResult() {
        given(getCharacterUseCase.invoke(anyLong())).willReturn(ResultState.Error)
    }

}