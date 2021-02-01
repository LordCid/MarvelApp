package com.example.marvelapp

import com.example.marvelapp.data.model.*
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

val concreteNetworkDataWrapperResponse = MarvelNetWorkCharacterDataWrapper(
    data = MarvelCharacterData(
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


val concreteOtherNetworkDataWrapperResponse = MarvelNetWorkCharacterDataWrapper(
    data = MarvelCharacterData(
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

fun getNetworkDataWrapperByCharId(id: Long) = MarvelNetWorkCharacterDataWrapper(
    data = MarvelCharacterData(
        limit = 3,
        total = 25,
        count = 20,
        results = listOf(
            MarvelCharacterNetworkModel(
                id = id,
                name = "Name",
                description = "description",
                modified = "modified",
                resourceURI = "uri",
                thumbnail = MarvelCharacterNetworkImage(path = "someUrl", extension = "extension"),
                urls = emptyList()
            )
        )
    )
)

fun getCharactertById(id: Long) = MarvelCharacter(
    id = id,
    name = "Name",
    description = "description",
    modified = "modified",
    resourceURI = "uri",
    thumbnail = "someUrl.extension",
    links = emptyList()
)