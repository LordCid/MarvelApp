package com.example.marvelapp.domain

import com.example.marvelapp.DATA_DATE_FORMAT
import com.example.marvelapp.SPAIN_LOCALE
import com.example.marvelapp.SPAIN_LOCALE_MIN
import com.example.marvelapp.data.model.MarvelCharacterNetworkImage
import com.example.marvelapp.data.model.MarvelCharacterNetworkModel
import com.example.marvelapp.data.model.MarvelNetWorkCharacterDataWrapper
import com.example.marvelapp.domain.model.MarvelCharacter
import java.text.SimpleDateFormat
import java.util.*

fun MarvelNetWorkCharacterDataWrapper.toDomain(): List<MarvelCharacter> {
    return this.data.results.map { it.toMarvelCharacter() }
}

fun MarvelNetWorkCharacterDataWrapper.getMarvelCharacter(): MarvelCharacter {
    return this.data.results.first().toMarvelCharacter()
}


private fun MarvelCharacterNetworkModel.toMarvelCharacter(): MarvelCharacter {
    return MarvelCharacter(
        id = id,
        name = name,
        description = description,
        modified = modified.toDate(),
        resourceURI = resourceURI,
        thumbnail = thumbnail.toDomain(),
        links = urls.map { it.url }
    )
}

private fun MarvelCharacterNetworkImage.toDomain(): String {
    return "$path.$extension"
}

private fun String.toDate(): Date? {
    val locale = Locale(SPAIN_LOCALE_MIN, SPAIN_LOCALE)
    return SimpleDateFormat(DATA_DATE_FORMAT, locale).parse(this)
}

