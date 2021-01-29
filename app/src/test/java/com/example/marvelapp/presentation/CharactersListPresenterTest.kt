package com.example.marvelapp.presentation

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import com.example.marvelapp.marvelCharacter
import com.example.marvelapp.otherMarvelCharacter
import com.example.marvelapp.presentation.list.CharacterListContract
import com.example.marvelapp.presentation.list.CharactersListPresenter
import com.nhaarman.mockitokotlin2.given
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
import org.mockito.Mockito

class CharactersListPresenterTest {

    private val view = mock<CharacterListContract.View>()
    private lateinit var sut: CharacterListContract.Presenter
    private val getCharactersUseCase = mock<GetCharactersUseCase>()

    @ExperimentalCoroutinesApi
    private var dispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        sut = CharactersListPresenter(view, getCharactersUseCase, dispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `Given product list get, it is shown into UI`() {
        runBlocking {
            val expectedList = listOf(marvelCharacter, marvelCharacter)
            givenSuccessResultWithValues(expectedList)

            sut.getCharacters()

            val inOrder = Mockito.inOrder(view, getCharactersUseCase)
            inOrder.verify(getCharactersUseCase).invoke()
            inOrder.verify(view).showMarvelCharacters(expectedList)
        }
    }

    @Test
    fun `Given OTHER product list get, it is shown into UI`() {
        runBlocking {
            val expectedList  = listOf(otherMarvelCharacter, otherMarvelCharacter)
            givenSuccessResultWithValues(expectedList)

            sut.getCharacters()

            val inOrder = Mockito.inOrder(view, getCharactersUseCase)
            inOrder.verify(getCharactersUseCase).invoke()
            inOrder.verify(view).showMarvelCharacters(expectedList)
        }
    }

    @Test
    fun `Given failure when getting product list, error is shown in the UI`() {
        runBlocking {
            givenFailureResult()

            sut.getCharacters()

            val inOrder = Mockito.inOrder(view, getCharactersUseCase)
            inOrder.verify(getCharactersUseCase).invoke()
            inOrder.verify(view).showError()
        }
    }

    private suspend fun givenSuccessResultWithValues(list: List<MarvelCharacter>) {
        given(getCharactersUseCase.invoke()).willReturn(ResultState.Success(list))
    }

    private suspend fun givenFailureResult() {
        given(getCharactersUseCase.invoke()).willReturn(ResultState.Error)
    }

}