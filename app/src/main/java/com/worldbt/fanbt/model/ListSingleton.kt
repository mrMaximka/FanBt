package com.worldbt.fanbt.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListSingleton @Inject constructor() {
    private var list: ArrayList<DreamModel> = ArrayList()

    fun setList(list: ArrayList<DreamModel>){
        this.list = list
    }

    fun getSize(): Int{
        return list.size
    }

    fun getModel(position: Int) : DreamModel{
        return list[position]
    }
}