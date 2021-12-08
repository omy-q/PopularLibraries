package com.example.popularlibraries.ui.user_info.view

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UserInfoView : MvpView {
    @AddToEndSingle
    fun setData(user: User)
    @AddToEndSingle
    fun updateRepositories(reps: List<Repository>)
}