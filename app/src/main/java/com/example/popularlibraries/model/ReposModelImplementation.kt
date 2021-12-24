package com.example.popularlibraries.model

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.model.RoomRepoModel
import io.reactivex.rxjava3.core.Single

class ReposModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val roomModel: RoomRepoModel
) : ReposModel {
    override fun getUserRepositories(user: User): Single<List<Repository>> {
        return if (status.isOnline()) {
            remoteService.getRepositories(user.reposUrl).flatMap(roomModel::saveUserRepos)
        } else {
            roomModel.getUserRepos(user.id)
        }
    }
}
