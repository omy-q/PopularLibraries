package com.example.popularlibraries.ui.users.presenter

import android.util.Log
import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.navigation.Screens.userInfo
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.users.view.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class UsersPresenter(
    router: Router,
    private val model: UsersModel
) : BasePresenter<UsersView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        usersListPresenter.itemClickListener = { pos ->
            router.navigateTo(userInfo(usersListPresenter.users[pos].login))
        }
    }

    private val observer = object
        : Observer<List<User>>{
        override fun onSubscribe(d: Disposable) {
            Log.d("RxJava", "Subscribed")
        }

        override fun onNext(users: List<User>) {
            usersListPresenter.users.addAll(users)
            viewState.updateUsers()
        }

        override fun onError(e: Throwable) {
            Log.e("RxJava", e.stackTraceToString())
        }

        override fun onComplete() {
            Log.d("RxJava", "Success")
        }

    }

    private fun loadData(){
        model.getUsers().subscribe(observer)
    }
}