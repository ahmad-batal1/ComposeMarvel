package com.example.composemarvel.data.di

import com.example.composemarvel.util.Constants.CLINT_PRIVATE_Key
import com.example.composemarvel.util.Constants.CLINT_PUBLIC_KEY
import com.example.composemarvel.util.md5
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class Interceptor : Interceptor {

    private val timeStamp =
        (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()

    override fun intercept(chain: Interceptor.Chain): Response {
        val url= chain.request()
            .url
            .newBuilder()
            .addQueryParameter("ts",timeStamp)
            .addQueryParameter("apikey", CLINT_PUBLIC_KEY)
            .addQueryParameter("hash", "$timeStamp$CLINT_PRIVATE_Key$CLINT_PUBLIC_KEY".md5())
            .build()

        return chain.proceed(chain.request().newBuilder().url(url).build())
    }
}