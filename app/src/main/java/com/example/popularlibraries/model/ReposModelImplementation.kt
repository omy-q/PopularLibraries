package com.example.popularlibraries.model

import com.example.popularlibraries.data.RepoOwner
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.model.RoomRepoModel
import com.example.popularlibraries.room.user_info.RepoEntity
import com.example.popularlibraries.room.users.UserEntity
import io.reactivex.rxjava3.core.Single

class ReposModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val roomModel: RoomRepoModel
) : ReposModel {
    override fun getUserRepositories(user: User): Single<List<Repository>> {
        return if (status.isOnline()) {
            remoteService.getRepositories(user.reposUrl).flatMap { repos ->
                roomModel.saveUserRepos(repos, user.id)
                Single.fromCallable {
                    repos
                }
            }
        } else {
            roomModel.getUserRepos(user.id)
        }
    }
}
