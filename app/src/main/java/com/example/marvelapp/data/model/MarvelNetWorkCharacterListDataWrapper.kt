package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class MarvelNetWorkCharacterListDataWrapper (
    @SerializedName("data") val data: MarvelCharacterListData,
)