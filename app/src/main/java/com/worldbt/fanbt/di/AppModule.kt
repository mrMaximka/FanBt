package com.worldbt.fanbt.di

import android.content.Context
import com.worldbt.fanbt.model.ListSingleton
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val applicationContext: Context) {

    @Singleton
    @Provides
    fun provideContext() = applicationContext

    @Singleton
    @Provides
    fun provideListSingleton() = ListSingleton()
}