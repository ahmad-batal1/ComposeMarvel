package com.example.composemarvel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterThumbnail(
    @SerializedName("extension")
    val thumbnailExtension: String,
    @SerializedName("path")
    val thumbnailPath: String
):Parcelable