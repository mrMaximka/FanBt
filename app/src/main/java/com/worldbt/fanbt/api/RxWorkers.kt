package com.worldbt.fanbt.api

import io.reactivex.Scheduler

data class RxWorkers(val subscribeWorker: Scheduler,
                     val observeWorker: Scheduler
)