package com.example.composemarvel.data.network

import com.example.composemarvel.data.model.MarvelResponse
import com.example.composemarvel.util.State
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {
    fun getListOfMarvelCharacters(): Single<State<MarvelResponse>>

    fun getMarvelCharacterByCharacterId(characterId:String):Single<State<MarvelResponse>>
}