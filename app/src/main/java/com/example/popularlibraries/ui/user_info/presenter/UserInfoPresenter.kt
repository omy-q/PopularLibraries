package com.example.popularlibraries.ui.user_info.presenter

import android.util.Log
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.model.ReposModel
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.navigation.Screens.repoInfo
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.user_info.view.UserInfoView
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UserInfoPresenter(
    router: Router,
    private val model: ReposModel
) : BasePresenter<UserInfoView>(router) {

    fun getData(user: User){
        viewState.setData(user)
        loadData(user)
    }

    private fun loadData(user: User) {
        model.getUserRepositories(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
                viewState.showLoading()
            }
            .subscribe({reps ->
                viewState.updateRepositories(reps)
                viewState.hideLoading()
            }, {
                viewState.hideLoading()
                Log.d("reps", "Error: ${it.stackTrace}")
            })
    }

    fun onItemClicked(repo: Repository){
        router.navigateTo(repoInfo(repo))
    }

}