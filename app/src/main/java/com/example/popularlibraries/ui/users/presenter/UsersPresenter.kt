package com.example.popularlibraries.ui.users.presenter

import com.example.popularlibraries.ui.users.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router
): MvpPresenter<UsersView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData(){
        TODO()
    }
}