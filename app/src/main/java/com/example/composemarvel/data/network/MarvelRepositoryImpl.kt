package com.example.composemarvel.data.network

import com.example.composemarvel.data.di.ApiModule
import com.example.composemarvel.data.model.MarvelCharacterResponse
import com.example.composemarvel.data.model.MarvelComicsResponse
import com.example.composemarvel.util.State
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

class MarvelRepositoryImpl : MarvelRepository {

    override fun getListOfMarvelCharacters(): Single<State<MarvelCharacterResponse>> {
        State.Loading
        return ApiModule.marvelService.getMarvelCharacters().map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }

    override fun getListOfMarvelComics(): Single<State<MarvelComicsResponse>> {
        State.Loading
        return ApiModule.marvelService.getMarvelComics().map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }

    override fun getMarvelCharactersByCharacterName(characterName: String): Flowable<State<MarvelCharacterResponse>> {
        State.Loading
        return ApiModule.marvelService.getMarvelCharactersByCharacterName(nameCharacter = characterName).map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }

    override fun getComicsCharacterByCharacterId(characterId: String): Flowable<State<MarvelComicsResponse>> {
        State.Loading
        return ApiModule.marvelService.getCharacterComicsByCharacterId(characterId = characterId).map {
            if (it.isSuccessful) State.Success(it.body())
            else State.Fail(it.message())
        }
    }
}