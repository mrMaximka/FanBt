package com.worldbt.fanbt.ui.game.start

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worldbt.fanbt.db.DbHelper
import com.worldbt.fanbt.db.DbTable
import com.worldbt.fanbt.di.App
import com.worldbt.fanbt.model.DreamModel
import com.worldbt.fanbt.model.ListSingleton
import javax.inject.Inject

class StartViewModel : ViewModel() {

    private val dbTable: DbTable = DbTable()

    var needToDream = MutableLiveData<Boolean>().apply { value = false }

    @Inject
    lateinit var single: ListSingleton

    fun onQuiz(context: Context?): ArrayList<DreamModel> {

        App.appComponent.inject(this)
        val database = DbHelper(context!!).writableDatabase
        val list = dbTable.loadDream(database)

        single.setList(list)
        return list
    }



    fun onDream() {
        needToDream.value = true
    }
}