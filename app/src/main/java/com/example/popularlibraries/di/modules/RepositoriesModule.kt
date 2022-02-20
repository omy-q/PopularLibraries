package com.example.popularlibraries.di.modules

import com.example.popularlibraries.App
import com.example.popularlibraries.di.scope.RepositoriesScope
import com.example.popularlibraries.di.scope.UsersScope
import com.example.popularlibraries.di.scope.containers.ReposScopeContainer
import com.example.popularlibraries.di.scope.containers.UsersScopeContainer
import com.example.popularlibraries.model.ReposModel
import com.example.popularlibraries.model.ReposModelImplementation
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.model.RoomRepoModel
import com.example.popularlibraries.room.model.RoomRepoModelImplementation
import com.example.popularlibraries.room.model.RoomUserModel
import com.example.popularlibraries.room.model.RoomUserModelImplementation
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoriesModule {

    @RepositoriesScope
    @Binds
    abstract fun bindReposModel(impl: ReposModelImplementation): ReposModel

    companion object{
        @RepositoriesScope
        @Provides
        fun reposRoomModel(db: DataBase): RoomRepoModel {
            return RoomRepoModelImplementation(db)
        }

        @RepositoriesScope
        @Provides
        fun scopeContainer(app: App): ReposScopeContainer = app
    }
}