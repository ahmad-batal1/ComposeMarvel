package com.example.composemarvel.data.di

import com.example.composemarvel.data.network.MarvelService
import com.example.composemarvel.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiModule {

//    private val interceptor = HttpLoggingInterceptor().apply {
//        setLevel(HttpLoggingInterceptor.Level.BODY)
//    }
//    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marvelService: MarvelService = retrofit.create(MarvelService::class.java)
}