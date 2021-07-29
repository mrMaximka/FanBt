package com.worldbt.fanbt.ui.game.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.worldbt.fanbt.R
import com.worldbt.fanbt.model.DreamModel
import kotlinx.android.synthetic.main.dream_fragment.*

class QuizFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var model: DreamModel
    private var questPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dream_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        loadQuest()
        setBtnSettings()
    }

    private fun setBtnSettings() {
        task_exit_btn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        task_next_btn.setOnClickListener {
            nextTask()
        }
        task_previous_btn.setOnClickListener {
            previousTask()
        }

        checkBtn()
    }

    private fun nextTask() {
        val newModel = viewModel.loadNextQuest()
        if (newModel != null){
            val res = resources.getIdentifier(newModel.image, "drawable", activity?.packageName)
            imageAnim(res)
            checkBtn()
        }
    }

    private fun checkBtn() {
        questPosition = viewModel.getPosition()
        if (questPosition < 1){
            task_previous_btn.visibility = View.INVISIBLE
        }else{
            task_previous_btn.visibility = View.VISIBLE
        }
        if (questPosition+1 >= viewModel.getModelsSize()){
            task_next_btn.visibility = View.INVISIBLE
        }else{
            task_next_btn.visibility = View.VISIBLE
        }
    }

    private fun previousTask() {
        val newModel = viewModel.loadPrevQuest()
        if (newModel != null){
            val res = resources.getIdentifier(newModel.image, "drawable", activity?.packageName)
            imageAnim(res)
            checkBtn()
        }
    }


    private fun loadQuest() {
        questPosition = arguments?.get("position") as Int
        model = viewModel.loadQuest(questPosition, context)

        val res = resources.getIdentifier(model.image, "drawable", activity?.packageName)
        val bitmap = ResourcesCompat.getDrawable(resources, res, context?.theme)?.toBitmap()
        task_image.setImageBitmap(bitmap)
    }

    private fun imageAnim(res: Int) {
        val animOut: Animation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_out)
        val animIn: Animation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in)

//        val res = resources.getIdentifier("q1_1", "drawable", activity?.packageName)
        val bitmap = ResourcesCompat.getDrawable(resources, res, context?.theme)?.toBitmap()

        animOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {

                task_image.setImageBitmap(bitmap)
                animIn.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {}
                    override fun onAnimationEnd(animation: Animation?) {}
                    override fun onAnimationRepeat(animation: Animation?) {}
                })
                task_image.startAnimation(animIn)
            }
        })
        task_image.startAnimation(animOut)
    }
}