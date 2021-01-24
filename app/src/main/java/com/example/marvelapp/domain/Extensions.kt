package com.example.marvelapp.domain

import com.example.marvelapp.data.model.MarvelCharacterNetworkImage
import com.example.marvelapp.data.model.MarvelCharacterNetworkModel
import com.example.marvelapp.data.model.MarvelDataNetWorkResponse
import com.example.marvelapp.domain.model.MarvelCharacter

fun MarvelDataNetWorkResponse.toDomain(): List<MarvelCharacter> {
    return this.data.results.map { it.toMarvelCharacter() }
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

