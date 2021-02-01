package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter

interface GetCharacterUseCase {
    suspend operator fun invoke(id: Long): ResultState<MarvelCharacter>
}