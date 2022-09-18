package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacterResponse(
    @SerializedName("data")
    val marvelDataResponse:MarvelCharacterResults
)