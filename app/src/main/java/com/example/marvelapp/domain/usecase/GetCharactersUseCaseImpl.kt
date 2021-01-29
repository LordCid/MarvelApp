package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.Repository
import com.example.marvelapp.domain.ResultState
import com.example.marvelapp.domain.model.MarvelCharacter
import javax.inject.Inject

class GetCharactersUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetCharactersUseCase {
    override suspend fun invoke() = repository.getCharacters()
}