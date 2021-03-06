package com.worldbt.fanbt.utils

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.worldbt.fanbt.R

object NavigationUtils {
    fun observerNavigation(
        activity: Activity,
        value: Boolean,
        liveBoolean: MutableLiveData<Boolean>,
        actionId: Int,
        bundle: Bundle? = null
    ) {
        try {
            if (value) {
                Navigation.findNavController(activity, R.id.nav_host_fragment)
                    .navigate(actionId, bundle)
                liveBoolean.value = false
            }
        } catch (t: Throwable) {
            Log.d("Nav", "NavError: ${t.localizedMessage}")
        }
    }
}