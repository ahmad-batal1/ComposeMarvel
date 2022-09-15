package com.example.composemarvel.data.network

import com.example.composemarvel.data.model.MarvelResponse
import com.example.composemarvel.util.Constants.CLIENT_ID
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {
    @GET("characters$CLIENT_ID")
    fun getMarvelCharacters(): Single<Response<MarvelResponse>>

    @GET("/characters/{characterId}/comics$CLIENT_ID")
    fun getCharacterComicsByCharacterId(
        @Path("characterId") characterId: String
    ):Single<Response<MarvelResponse>>

    @GET("characters/{characterId}$CLIENT_ID")
    fun getMarvelCharacterById(
        @Path("characterId") characterId:String
    ):Single<Response<MarvelResponse>>
}