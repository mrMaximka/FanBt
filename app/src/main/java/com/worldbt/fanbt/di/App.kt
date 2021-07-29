package com.worldbt.fanbt.di

import androidx.multidex.MultiDexApplication

class App : MultiDexApplication() {
    companion object{
        lateinit var appComponent: AppComponent
        var instance: App? = null
            private  set
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .build()
    }
}