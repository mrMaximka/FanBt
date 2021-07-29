package com.worldbt.fanbt.api

import com.worldbt.fanbt.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createService(clazz: Class<T>, serverUrl: String) = Retrofit.Builder()
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(serverUrl)
    .client(
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(loggingInterceptor())
            .build()
    )
    .build()
    .create(clazz)

private fun loggingInterceptor() = HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

