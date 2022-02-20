package com.example.popularlibraries.di

import com.example.popularlibraries.di.modules.RepositoriesModule
import com.example.popularlibraries.di.scope.RepositoriesScope
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import dagger.Subcomponent

@RepositoriesScope
@Subcomponent(
    modules = [
        RepositoriesModule::class
    ]
)
interface ReposSubcomponent {
    fun repoInfoSubcomponent(): RepoInfoSubcomponent
    fun userInfoPresenter(): UserInfoPresenter
}