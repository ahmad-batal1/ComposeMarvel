package com.example.composemarvel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterMoreInformationUrl(
    @SerializedName("url")
    val moreInformationUrl: String
):Parcelable