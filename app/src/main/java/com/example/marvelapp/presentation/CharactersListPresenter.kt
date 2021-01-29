package com.example.marvelapp.presentation

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class CharactersListPresenter @Inject constructor(
    private val view: CharacterListContract.View,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterListContract.Presenter, CoroutineScope by MainScope() {
    override fun getCharacters() {
        launch {
            val result = withContext(ioDispatcher){ getCharactersUseCase() }
            when(result){
                is ResultState.Success -> view.showMarvelCharacters(result.data)
                is ResultState.Error -> view.showError()
            }
        }
    }
}