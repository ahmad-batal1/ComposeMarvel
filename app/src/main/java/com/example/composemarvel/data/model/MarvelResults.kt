package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelResults(
    @SerializedName("results")
    val MarvelResult: List<MarvelCharacter>,
)