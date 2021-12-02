package com.example.popularlibraries.ui.user_info.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UserInfoView : MvpView {
    @AddToEndSingle
    fun setLogin(login: String)
}