package com.example.marvelapp.presentation.detail

import android.util.Log
import com.example.marvelapp.MARVEL_TAG
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class CharacterDetailPresenter @Inject constructor(
    private val view: CharacterDetailContract.View,
    private val getCharactersUseCase: GetCharacterUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterDetailContract.Presenter, CoroutineScope by MainScope() {
    override fun getCharacter(id: Long) {
        Log.d(MARVEL_TAG, "getCharacter: $id" )
        launch {
            val result = withContext(ioDispatcher){ getCharactersUseCase(id) }
            when(result){
                is ResultState.Success -> view.showData(result.data)
                is ResultState.Error -> view.showError()
            }

        }
    }
}