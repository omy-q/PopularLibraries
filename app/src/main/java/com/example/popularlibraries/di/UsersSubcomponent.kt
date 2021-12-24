package com.example.popularlibraries.di

import com.example.popularlibraries.di.modules.UsersModule
import com.example.popularlibraries.di.scope.UsersScope
import com.example.popularlibraries.ui.users.presenter.UsersPresenter
import dagger.Subcomponent

@UsersScope
@Subcomponent(
    modules = [
        UsersModule::class
    ]
)
interface UsersSubcomponent {
    fun reposSubcomponent(): ReposSubcomponent
    fun usersPresenter(): UsersPresenter
}