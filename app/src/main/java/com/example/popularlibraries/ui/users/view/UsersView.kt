package com.example.popularlibraries.ui.users.view

import com.example.popularlibraries.data.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView: MvpView {
    @AddToEndSingle
    fun updateUsers(users: List<User>)
}