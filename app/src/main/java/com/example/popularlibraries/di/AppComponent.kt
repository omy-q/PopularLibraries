package com.example.popularlibraries.di

import com.example.popularlibraries.di.modules.*
import com.example.popularlibraries.ui.main.presenter.MainPresenter
import com.example.popularlibraries.ui.main.view.MainActivity
import com.example.popularlibraries.ui.repo_info.presenter.RepoInfoPresenter
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import com.example.popularlibraries.ui.users.presenter.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        CacheModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        ContextModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userInfoPresenter: UserInfoPresenter)
    fun inject(repoInfoPresenter: RepoInfoPresenter)
}