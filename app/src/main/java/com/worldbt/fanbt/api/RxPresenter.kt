package com.worldbt.fanbt.api

import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxPresenter<V : View> {

    protected var view: V? = null
    private val subscriptions = CompositeDisposable()

    fun bindView(view: V) {
        this.view = view
    }

    fun unbindView() {
        subscriptions.clear()
        this.view = null
    }

    protected fun addSubscription(subscription: Disposable) = subscriptions.add(subscription)
}