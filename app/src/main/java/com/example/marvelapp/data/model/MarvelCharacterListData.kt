package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacterListData (
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<MarvelCharacterNetworkModel>
)
