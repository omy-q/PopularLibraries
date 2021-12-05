package com.example.popularlibraries.ui.main.presenter

import com.example.popularlibraries.navigation.Screens
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.main.view.MainView
import com.github.terrakok.cicerone.Router

class MainPresenter(
    router: Router
): BasePresenter<MainView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.users())
    }
}