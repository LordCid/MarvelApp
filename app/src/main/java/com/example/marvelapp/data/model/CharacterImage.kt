package com.example.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterImage(
    @SerializedName("path")val path: String,
    @SerializedName("extension") val extension: String
)