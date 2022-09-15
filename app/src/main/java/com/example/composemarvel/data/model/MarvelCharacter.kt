package com.example.composemarvel.data.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacter(
    @SerializedName("id")
    val characterId: Int?,
    @SerializedName("name")
    val characterName: String?,
    @SerializedName("comics")
    val characterComicsPath: CharacterComics?,
    @SerializedName("description")
    val characterDescription: String?,
    @SerializedName("modified")
    val characterModified: String?,
    @SerializedName("thumbnail")
    val characterThumbnail: CharacterThumbnail?,
    @SerializedName("urls")
    val characterMoreInformationUrls: List<MoreInformationUrl>
)