package com.example.popularlibraries.di

import com.example.popularlibraries.di.modules.*
import com.example.popularlibraries.ui.main.presenter.MainPresenter
import com.example.popularlibraries.ui.main.view.MainActivity
import dagger.Component

@Component(
    modules = [
        CacheModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        ContextModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

}