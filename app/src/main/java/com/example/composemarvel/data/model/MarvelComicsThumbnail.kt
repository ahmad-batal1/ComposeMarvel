package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelComicsThumbnail(
    @SerializedName("extension")
    val thumbnailExtension: String,
    @SerializedName("path")
    val thumbnailPath: String
)
