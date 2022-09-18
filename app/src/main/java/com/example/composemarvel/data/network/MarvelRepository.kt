package com.example.composemarvel.data.network

import com.example.composemarvel.data.model.MarvelCharacterResponse
import com.example.composemarvel.data.model.MarvelComicsResponse
import com.example.composemarvel.util.State
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {
    fun getListOfMarvelCharacters(): Single<State<MarvelCharacterResponse>>

    fun getListOfMarvelComics(): Single<State<MarvelComicsResponse>>

    fun getMarvelCharactersByCharacterName(characterName:String): Flowable<State<MarvelCharacterResponse>>

    fun getComicsCharacterByCharacterId(characterId: String): Flowable<State<MarvelComicsResponse>>
}