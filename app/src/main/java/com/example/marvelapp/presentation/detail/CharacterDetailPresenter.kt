package com.example.marvelapp.presentation.detail

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class CharacterDetailPresenter @Inject constructor(
    private val view: CharacterDetailContract.View,
    private val getCharactersUseCase: GetCharacterUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterDetailContract.Presenter, CoroutineScope by MainScope() {

    private var job : Job? = null

    override fun getCharacter(id: Long) {
        job = launch {
            val result = withContext(ioDispatcher){ getCharactersUseCase(id) }
            when(result){
                is ResultState.Success -> view.showData(result.data)
                is ResultState.Error -> view.showError()
            }

        }
    }

    override fun onDestroy() {
        job?.cancel()
    }
}