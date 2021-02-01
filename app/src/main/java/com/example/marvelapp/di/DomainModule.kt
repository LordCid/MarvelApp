package com.example.marvelapp.di

import com.example.marvelapp.domain.Utilities
import com.example.marvelapp.domain.UtilitiesImpl
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.domain.usecase.GetCharacterUseCaseImpl
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import com.example.marvelapp.domain.usecase.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindUtilities(utilities: UtilitiesImpl): Utilities

    @Binds
    fun bindGetCharactersUseCase(usecase: GetCharactersUseCaseImpl): GetCharactersUseCase

    @Binds
    fun bindGetCharacterUseCase(usecase: GetCharacterUseCaseImpl): GetCharacterUseCase
}