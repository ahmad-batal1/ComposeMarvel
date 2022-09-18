package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelComicsResponse(
    @SerializedName("data")
    val marvelDataResponse:MarvelComicsResult
)
