package com.worldbt.fanbt.ui.game.start

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.worldbt.fanbt.R
import com.worldbt.fanbt.model.DreamModel

class StartAdapter (private val listener: DreamClick, private val requireContext: Context) : RecyclerView.Adapter<StartViewHolder>() {

    private var list: ArrayList<DreamModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dream_list, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.bind(list[position], position, listener, requireContext)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: ArrayList<DreamModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    interface DreamClick{
        fun onDreamClick(position: Int)
    }
}