package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelNetWorkCharacterDataWrapper (
    @SerializedName("data") val data: MarvelCharacterData,
)