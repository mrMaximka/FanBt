package com.worldbt.fanbt.ui.game.quiz

import android.content.Context
import androidx.lifecycle.ViewModel
import com.worldbt.fanbt.di.App
import com.worldbt.fanbt.model.DreamModel
import com.worldbt.fanbt.model.ListSingleton
import javax.inject.Inject

class QuizViewModel : ViewModel() {

    private lateinit var model: DreamModel
    private lateinit var context: Context
    private var position: Int = 0

    @Inject
    lateinit var single: ListSingleton


    fun loadQuest(
        questPosition: Int,
        context: Context?
    ) : DreamModel{

        this.position = questPosition
        this.context = context!!

        App.appComponent.inject(this)
        model = single.getModel(questPosition)

        return model
    }

    fun loadNextQuest(): DreamModel?{

        return if (position+1 < getModelsSize()){
            position++
            model = single.getModel(position)
            model
        }else{
            null
        }
    }

    fun loadPrevQuest(): DreamModel?{

        return if (position-1 >= 0){
            position--
            model = single.getModel(position)
            model
        }else{
            null
        }
    }

    fun getModelsSize(): Int{
        return single.getSize()
    }

    fun getPosition(): Int{
        return position
    }
}