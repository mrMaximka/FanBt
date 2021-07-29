package com.worldbt.fanbt.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    companion object {
        private const val PLATFORM = "Android"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("User-Agent", PLATFORM)

        return chain.proceed(builder.build())
    }
}