package com.example.marvelapp.domain.model

import java.util.*


data class MarvelCharacter(
    val id: Long,
    val name: String,
    val description: String,
    val modified: Date?,
    val resourceURI: String,
    val thumbnail: String,
    val links: List<String>
)