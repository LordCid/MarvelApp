package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter

interface GetCharactersUseCase {
    suspend operator fun invoke(): ResultState<List<MarvelCharacter>>
}