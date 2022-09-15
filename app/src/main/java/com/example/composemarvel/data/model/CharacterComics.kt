package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class CharacterComics(
    @SerializedName("collectionURI")
    val ComicsPath: String
)