package com.example.popularlibraries.di

import com.example.popularlibraries.di.modules.*
import com.example.popularlibraries.ui.main.presenter.MainPresenter
import com.example.popularlibraries.ui.main.view.MainActivity
import com.example.popularlibraries.ui.repo_info.presenter.RepoInfoPresenter
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import com.example.popularlibraries.ui.users.presenter.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        CiceroneModule::class,
        NetworkModule::class,
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun usersSubComponent(): UsersSubcomponent
}