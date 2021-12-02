package com.example.popularlibraries.ui.users.presenter

import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.ui.base.ListPresenter
import com.example.popularlibraries.ui.users.view.UserItemView
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
        usersListPresenter.itemClickListener = {}
    }

    private fun loadData(){
        usersListPresenter.users.addAll(model.getUsers())
        viewState.updateUsers()
    }

    class UserListPresenter: ListPresenter<UserItemView> {
        val users = mutableListOf<User>()
        override var itemClickListener =  {}

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}