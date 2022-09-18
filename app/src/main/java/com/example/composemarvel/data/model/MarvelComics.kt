package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelComics(
    @SerializedName("id")
    val comicsId: String,
    @SerializedName("title")
    val comicsName: String,
    @SerializedName("description")
    val comicsDescription: String,
    @SerializedName("modified")
    val comicsModified: String,
    @SerializedName("thumbnail")
    val comicsThumbnail: MarvelComicsThumbnail,
)
