package com.example.popularlibraries.ui.users.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView: MvpView {
    @AddToEndSingle
    fun updateUsers()
}