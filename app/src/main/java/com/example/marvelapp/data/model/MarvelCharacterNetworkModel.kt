package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacterNetworkModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("thumbnail") val thumbnail: MarvelCharacterNetworkImage,
    @SerializedName("urls") val urls: List<MarvelCharacterNetworkURLS>
)