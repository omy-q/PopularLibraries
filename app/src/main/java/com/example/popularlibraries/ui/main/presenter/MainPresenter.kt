package com.example.popularlibraries.ui.main.presenter

import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.main.view.MainView
import javax.inject.Inject

class MainPresenter @Inject constructor(): BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.users())
    }
}