package com.example.popularlibraries.ui.base

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<V: MvpView>(
    val router: Router
): MvpPresenter<V>() {

    fun backPressed():Boolean{
        router.exit()
        return true
    }
}