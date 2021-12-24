package com.example.popularlibraries.di.modules

import com.example.popularlibraries.model.ReposModel
import com.example.popularlibraries.model.ReposModelImplementation
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.model.UsersModelImplementation
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUsersModel(impl: UsersModelImplementation): UsersModel

    @Singleton
    @Binds
    abstract fun bindReposModel(impl: ReposModelImplementation): ReposModel
}