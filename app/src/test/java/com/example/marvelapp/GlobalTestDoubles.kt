package com.example.marvelapp

import com.example.marvelapp.data.model.MarvelCharacterNetworkImage
import com.example.marvelapp.data.model.MarvelCharacterNetworkModel
import com.example.marvelapp.data.model.MarvelCharacterResults
import com.example.marvelapp.data.model.MarvelDataNetWorkResponse
import com.example.marvelapp.domain.model.MarvelCharacter

val networkMarvelCharacter = MarvelCharacterNetworkModel(
    id = 1,
    name = "Name",
    description = "description",
    modified = "modified",
    resourceURI = "uri",
    thumbnail = MarvelCharacterNetworkImage(path = "someUrl", extension = "extension"),
    urls = emptyList()
)

val concreteNetworkModelResponse = MarvelDataNetWorkResponse(
    data = MarvelCharacterResults(
        limit = 3,
        total = 25,
        count = 20,
        results = listOf(
            networkMarvelCharacter,
            networkMarvelCharacter,
            networkMarvelCharacter
        )
    )
)

val otherNetworkMarvelCharacter = MarvelCharacterNetworkModel(
    id = 2,
    name = "OtherName",
    description = "other description",
    modified = "modified",
    resourceURI = "uri",
    thumbnail = MarvelCharacterNetworkImage(path = "someUrl", extension = "extension"),
    urls = emptyList()
)


val concreteOtherNetworkModel = MarvelDataNetWorkResponse(
    data = MarvelCharacterResults(
        limit = 3,
        total = 25,
        count = 20,
        results = listOf(
            otherNetworkMarvelCharacter,
            otherNetworkMarvelCharacter,
            otherNetworkMarvelCharacter
        )
    )
)



val marvelCharacter = MarvelCharacter(
    id = 1,
    name = "Name",
    description = "description",
    modified = "modified",
    resourceURI = "uri",
    thumbnail = "someUrl.extension",
    links = emptyList()
)


val otherMarvelCharacter = MarvelCharacter(
    id = 2,
    name = "OtherName",
    description = "other description",
    modified = "modified",
    resourceURI = "uri",
    thumbnail = "someUrl.extension",
    links = emptyList()
)
