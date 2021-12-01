package com.example.popularlibraries.ui.main.presenter

import com.example.popularlibraries.navigation.Screens
import com.example.popularlibraries.ui.main.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
): MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.users())
    }

    fun backPressed(){
        router.exit()
    }
}