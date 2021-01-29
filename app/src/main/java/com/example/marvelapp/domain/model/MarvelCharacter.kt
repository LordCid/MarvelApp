package com.example.marvelapp.domain.model


data class MarvelCharacter(
    val id: Long,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val thumbnail: String,
    val links: List<String>
)