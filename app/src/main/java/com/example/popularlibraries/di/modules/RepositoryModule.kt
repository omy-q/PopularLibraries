package com.example.popularlibraries.di.modules

import com.example.popularlibraries.model.ReposModel
import com.example.popularlibraries.model.ReposModelImplementation
import com.example.popularlibraries.model.UsersModel
import com.example.popularlibraries.model.UsersModelImplementation
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.model.RoomRepoModel
import com.example.popularlibraries.room.model.RoomUserModel
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun usersModel(
        status: NetworkStatus,
        remoteService: RetrofitService,
        roomModel: RoomUserModel
    ):UsersModel{
        return UsersModelImplementation(status, remoteService, roomModel)
    }

    @Provides
    fun reposModel(
        status: NetworkStatus,
        remoteService: RetrofitService,
        roomModel: RoomRepoModel
    ): ReposModel{
        return ReposModelImplementation(status, remoteService, roomModel)
    }
}