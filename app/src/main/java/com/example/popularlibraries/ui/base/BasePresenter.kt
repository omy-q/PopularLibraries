package com.example.popularlibraries.ui.base

import com.example.popularlibraries.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject

abstract class BasePresenter<V: MvpView>: MvpPresenter<V>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screen: Screens

    fun backPressed():Boolean{
        router.exit()
        return true
    }
}