package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacterNetworkURLS (
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
)

