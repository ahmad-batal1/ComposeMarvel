package com.example.composemarvel.data.di

import com.example.composemarvel.data.network.MarvelService
import com.example.composemarvel.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.internal.platform.android.AndroidLogHandler.setLevel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiModule {

    private val client = OkHttpClient.Builder().addInterceptor(Interceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marvelService: MarvelService = retrofit.create(MarvelService::class.java)
}