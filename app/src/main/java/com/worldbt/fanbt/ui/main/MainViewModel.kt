package com.worldbt.fanbt.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worldbt.fanbt.BuildConfig
import com.worldbt.fanbt.api.RxWorkers
import com.worldbt.fanbt.api.SplashApi
import com.worldbt.fanbt.api.composeWith
import com.worldbt.fanbt.api.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    var needToGame = MutableLiveData<Boolean>().apply { value = false }
    var needToWeb = MutableLiveData<Boolean>().apply { value = false }
    private val serverApi by lazy { createService(SplashApi::class.java, BuildConfig.BASE_URL) }
    private var webLink: String = ""

    fun onGame() {
        needToGame.value = true
    }

    fun loadData(context: Context?) {

        addSubscription(

            serverApi.getLink(BuildConfig.APP_UUID, BuildConfig.APPLICATION_ID)
                .composeWith(RxWorkers(Schedulers.io(), AndroidSchedulers.mainThread()))
                .subscribe({ isLinkValid(it.link) }, {
                    onError(context)
                })
        )

    }

    private val subscriptions = CompositeDisposable()
    private fun addSubscription(subscription: Disposable) = subscriptions.add(subscription)

    private fun isLinkValid(link: String) {
        if (link.isNotEmpty() && isSource(link)) {
            loadWebView(link)
        } else {
            loadGame()
        }
    }

    private fun loadWebView(link: String) {
        this.webLink = link
        needToWeb.value = true
    }

    fun getLink(): String {
        return webLink
    }

    private fun loadGame() {
        onGame()
    }

    private fun isSource(link: String): Boolean {
        return link.contains("source=true")
    }

    private fun onError(context: Context?) {
        onGame()
    }
}