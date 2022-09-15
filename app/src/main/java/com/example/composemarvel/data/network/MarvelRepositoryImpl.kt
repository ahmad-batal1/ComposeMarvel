package com.example.composemarvel.data.network

import com.example.composemarvel.data.di.ApiModule
import com.example.composemarvel.data.model.MarvelResponse
import com.example.composemarvel.util.State
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MarvelRepositoryImpl : MarvelRepository {
    override fun getListOfMarvelCharacters(): Single<State<MarvelResponse>> {
        State.Loading
        return ApiModule.marvelService.getMarvelCharacters().map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }

    override fun getMarvelCharacterByCharacterId(characterId: String): Single<State<MarvelResponse>> {
        State.Loading
        return ApiModule.marvelService.getMarvelCharacterById(characterId).map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }
}