package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelDataNetWorkResponse (
    @SerializedName("data") val data: MarvelCharacterResults,
)