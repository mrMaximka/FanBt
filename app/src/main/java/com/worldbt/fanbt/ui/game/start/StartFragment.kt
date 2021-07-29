package com.worldbt.fanbt.ui.game.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.worldbt.fanbt.R
import com.worldbt.fanbt.utils.NavigationUtils
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : Fragment(), StartAdapter.DreamClick {

    private lateinit var viewModel: StartViewModel
    private val bundle: Bundle = Bundle()
    private lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.needToDream.observe(viewLifecycleOwner, {
            it?.let {
                NavigationUtils.observerNavigation(
                    requireActivity(),
                    it,
                    viewModel.needToDream,
                    R.id.action_nav_start_to_nav_quiz,
                    bundle
                )
            }
        })

    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        activity?.setTheme(R.style.AppTheme)
        activity?.window?.setBackgroundDrawableResource(R.drawable.splash_color)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activity?.window?.statusBarColor = requireActivity().resources.getColor(R.color.colorAlfaWhite, activity?.theme)
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    activity?.moveTaskToBack(true)
                    activity?.finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        loadList()
    }

    private fun loadList() {
        adapter = StartAdapter(this, requireContext())
        dream_list.adapter = adapter
        adapter.setData(viewModel.onQuiz(requireContext()))
    }

    override fun onDreamClick(position: Int) {
        bundle.putInt("position", position)
        viewModel.onDream()
    }
}