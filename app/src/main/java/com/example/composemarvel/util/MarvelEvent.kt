package com.example.composemarvel.util

sealed class MarvelEvent {
    data class OnClickCharacterItem(val characterId:Int)
}