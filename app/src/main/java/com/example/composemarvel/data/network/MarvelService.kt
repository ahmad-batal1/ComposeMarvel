package com.example.composemarvel.data.network

import com.example.composemarvel.data.model.MarvelCharacterResponse
import com.example.composemarvel.data.model.MarvelComicsResponse
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    fun getMarvelCharacters(
        @Query("limit") limitCountCharacters:String?="70"
    ): Single<Response<MarvelCharacterResponse>>

    @GET("comics")
    fun getMarvelComics(
        @Query("limit") limitCountCharacters:String?="60"
    ): Single<Response<MarvelComicsResponse>>

    @GET("characters/{characterId}/comics")
    fun getCharacterComicsByCharacterId(
        @Path("characterId") characterId: String,
        @Query("limit") limitCountCharacters:String?="15"
    ):Flowable<Response<MarvelComicsResponse>>

    @GET("characters")
    fun getMarvelCharactersByCharacterName(
        @Query("nameStartsWith") nameCharacter:String?="wong",
        @Query("limit") limitCountCharacters:String?="25"
    ): Flowable<Response<MarvelCharacterResponse>>
}