package com.example.popularlibraries.di.modules

import com.example.popularlibraries.App
import com.example.popularlibraries.di.scope.UsersScope
import com.example.popularlibraries.di.scope.containers.UsersScopeContainer
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.model.UsersModelImplementation
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.model.RoomUserModel
import com.example.popularlibraries.room.model.RoomUserModelImplementation
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UsersModule {

    @UsersScope
    @Binds
    abstract fun bindUsersModel(impl: UsersModelImplementation): UsersModel

    companion object{
        @UsersScope
        @Provides
        fun usersRoomModel(db: DataBase): RoomUserModel{
            return RoomUserModelImplementation(db)
        }

        @UsersScope
        @Provides
        fun scopeContainer(app: App): UsersScopeContainer = app
    }
}