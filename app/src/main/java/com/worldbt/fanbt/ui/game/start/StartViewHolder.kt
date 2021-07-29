package com.worldbt.fanbt.ui.game.start

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.worldbt.fanbt.R
import com.worldbt.fanbt.model.DreamModel
import kotlinx.android.synthetic.main.item_dream_list.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StartViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var listener: StartAdapter.DreamClick
    private var pos = 0

    fun bind(
        dreamModel: DreamModel,
        position: Int,
        listener: StartAdapter.DreamClick,
        requireContext: Context
    ) {
        this.listener = listener
        this.pos = position
        var bitmap: Bitmap? = null


        GlobalScope.launch {
            Log.d("MMV", position.toString())
            val res = requireContext.resources.getIdentifier(dreamModel.image, "drawable", requireContext.packageName)
            bitmap = ResourcesCompat.getDrawable(requireContext.resources, res, requireContext.theme)?.toBitmap()
            withContext(Dispatchers.Main){
                Glide.with(requireContext)
                    .load(bitmap)
                    .placeholder(R.drawable.q1)
                    .into(itemView.item_image)
            }
        }
        itemView.item_name.text = dreamModel.name

        itemView.setOnClickListener {
            listener.onDreamClick(position)
        }
    }
}