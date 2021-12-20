package com.example.popularlibraries.ui.users.presenter

import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.navigation.Screens.userInfo
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.users.view.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .subscribe({ users ->
                viewState.updateUsers(users)
                viewState.hideLoading()
            }, {
                viewState.hideLoading()
            })
    }

    fun onItemClicked(user: User) {
        router.navigateTo(userInfo(user))
    }
}