package com.example.popularlibraries.ui.users.presenter

import com.example.popularlibraries.data.User
import com.example.popularlibraries.ui.base.recyclerview.ListPresenter
import com.example.popularlibraries.ui.users.view.recyclerview.UserItemView

class UserListPresenter: ListPresenter<UserItemView> {
    val users = mutableListOf<User>()
    override var itemClickListener: (pos: Int) -> Unit = {}

    override fun getCount() = users.size

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }
}