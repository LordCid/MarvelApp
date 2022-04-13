package com.example.marvelapp.presentation.list

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class CharactersListPresenter @Inject constructor(
    private val view: CharacterListContract.View,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterListContract.Presenter, CoroutineScope by MainScope() {

    private var job : Job? = null

    override fun getCharacters() {
        job = launch {
            when(val result = withContext(ioDispatcher){ getCharactersUseCase() }){
                is ResultState.Success -> view.showMarvelCharacters(result.data)
                is ResultState.Error -> view.showError()
            }
        }
    }

    override fun onDestroy() {
        job?.cancel()
    }
}