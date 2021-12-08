package com.example.popularlibraries.ui.user_info.presenter

import android.util.Log
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.user_info.view.UserInfoView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UserInfoPresenter(
    router: Router,
    private val model: UsersModel
) : BasePresenter<UserInfoView>(router) {

    fun getData(user: User){
        viewState.setData(user)
        loadData(user.reposUrl)
    }

    private fun loadData(url: String) {
        model.getUserRepositories(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({reps ->
                       viewState.updateRepositories(reps)
            }, {
                Log.d("reps", "Error: ${it.stackTrace}")
            })
    }

    fun onItemClicked(repo: Repository){
        Log.d("reps", "repo clicked: ${repo}")
    }

}