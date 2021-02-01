package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.Repository
import javax.inject.Inject

class GetCharacterUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetCharacterUseCase {
    override suspend fun invoke(id: Long) = repository.getCharacter(id)
}