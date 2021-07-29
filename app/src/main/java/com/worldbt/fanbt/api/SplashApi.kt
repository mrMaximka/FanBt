package com.worldbt.fanbt.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SplashApi {
    @GET("applications/{uuid}")
    fun getLink(@Path("uuid") uuid: String, @Query("application") applicationID: String): Single<LinkResponse>

}