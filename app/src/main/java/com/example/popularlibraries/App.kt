package com.example.popularlibraries

import android.app.Application
import com.example.popularlibraries.di.*
import com.example.popularlibraries.di.modules.AppModule
import com.example.popularlibraries.di.scope.containers.RepoInfoScopeContainer
import com.example.popularlibraries.di.scope.containers.ReposScopeContainer
import com.example.popularlibraries.di.scope.containers.UsersScopeContainer

class App : Application(), UsersScopeContainer, ReposScopeContainer, RepoInfoScopeContainer {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    var usersSubcomponent: UsersSubcomponent? = null
    var reposSubcomponent: ReposSubcomponent? = null
    var repoInfoSubcomponent: RepoInfoSubcomponent? = null


    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun initUsersSubcomponent() =
        appComponent.usersSubComponent().also {
            usersSubcomponent = it
        }

    override fun destroyUsersSubcomponent() {
        usersSubcomponent = null
    }

    override fun initReposSubcomponent() =
        appComponent.usersSubComponent().reposSubcomponent().also {
            reposSubcomponent = it
        }

    override fun destroyReposSubcomponent() {
        reposSubcomponent = null
    }

    override fun initRepoInfoSubcomponent() =
        appComponent.usersSubComponent().reposSubcomponent().repoInfoSubcomponent().also {
            repoInfoSubcomponent = it
        }

    override fun destroyRepoInfoSubcomponent() {
        repoInfoSubcomponent = null
    }

    companion object {
        private var _instance: App? = null
        val instance get() = _instance!!
    }
}