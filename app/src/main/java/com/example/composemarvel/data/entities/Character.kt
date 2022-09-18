package com.example.composemarvel.data.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class Character(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val character_id: String,
    val character_name:String,
    val characterModified:String,
    @ColumnInfo(
        name = "image",
        typeAffinity = ColumnInfo.BLOB
    ) val character_image: Bitmap
)