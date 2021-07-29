package com.worldbt.fanbt.di

import com.worldbt.fanbt.ui.game.quiz.QuizViewModel
import com.worldbt.fanbt.ui.game.start.StartViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(viewModel: StartViewModel)
    fun inject(viewModel: QuizViewModel)
}