package com.example.popularlibraries.ui.users.presenter

import android.util.Log
import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.navigation.Screens.userInfo
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.users.view.UsersView
import com.github.terrakok.cicerone.Router

class UsersPresenter(
    router: Router,
    private val model: UsersModel
) : BasePresenter<UsersView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        model.getUsers()
            .doOnNext { users ->
                viewState.updateUsers(users)
            }
            .doOnError { e ->
                Log.e("RxJava", e.stackTraceToString())
            }
            .subscribe()
    }

    fun onItemClicked(user: User) {
        router.navigateTo(userInfo(user.login))
    }
}