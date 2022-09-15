package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    @SerializedName("data")
    val marvelDataResponse:MarvelResults
)