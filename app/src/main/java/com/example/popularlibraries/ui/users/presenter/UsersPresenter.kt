package com.example.popularlibraries.ui.users.presenter

import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.navigation.Screens.userInfo
import com.example.popularlibraries.ui.users.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val model: UsersModel
): MvpPresenter<UsersView>() {

    val usersListPresenter = UserListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        usersListPresenter.itemClickListener = { pos ->
            router.navigateTo(userInfo(usersListPresenter.users[pos].login))
        }
    }

    private fun loadData(){
        usersListPresenter.users.addAll(model.getUsers())
        viewState.updateUsers()
    }

    fun backPressed():Boolean{
        router.exit()
        return true
    }
}