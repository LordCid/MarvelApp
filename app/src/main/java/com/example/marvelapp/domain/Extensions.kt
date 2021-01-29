package com.example.marvelapp.domain

import com.example.marvelapp.data.model.MarvelCharacterNetworkImage
import com.example.marvelapp.data.model.MarvelCharacterNetworkModel
import com.example.marvelapp.data.model.MarvelNetWorkCharacterDataWrapper
import com.example.marvelapp.data.model.MarvelNetWorkCharacterListDataWrapper
import com.example.marvelapp.domain.model.MarvelCharacter

fun MarvelNetWorkCharacterListDataWrapper.toDomain(): List<MarvelCharacter> {
    return this.data.results.map { it.toMarvelCharacter() }
}

fun MarvelNetWorkCharacterDataWrapper.toDomain(): MarvelCharacter {
    return this.data.character.toMarvelCharacter()
}

private fun MarvelCharacterNetworkModel.toMarvelCharacter() : MarvelCharacter {
    return MarvelCharacter(
        id = id,
        name = name,
        description = description,
        modified = modified,
        resourceURI = resourceURI,
        thumbnail = thumbnail.toDomain(),
        links = urls.map { it.url }
    )
}

private fun MarvelCharacterNetworkImage.toDomain(): String{
    return "$path.$extension"
}

