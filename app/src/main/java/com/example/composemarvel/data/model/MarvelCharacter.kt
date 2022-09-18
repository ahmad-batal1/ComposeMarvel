package com.example.composemarvel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelCharacter(
    @SerializedName("id")
    val characterId: String,
    @SerializedName("name")
    val characterName: String,
    @SerializedName("description")
    val characterDescription: String,
    @SerializedName("modified")
    val characterModified: String,
    @SerializedName("thumbnail")
    val characterThumbnail: CharacterThumbnail,
    @SerializedName("urls")
    val characterMoreInformationUrls: List<CharacterMoreInformationUrl>
):Parcelable