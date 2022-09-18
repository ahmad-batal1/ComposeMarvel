package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelComicsResult(
    @SerializedName("results")
    val MarvelResult: List<MarvelComics>,
)
