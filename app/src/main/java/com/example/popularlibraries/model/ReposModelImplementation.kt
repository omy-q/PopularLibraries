package com.example.popularlibraries.model

import com.example.popularlibraries.data.RepoOwner
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.user_info.RepoEntity
import com.example.popularlibraries.room.users.UserEntity
import io.reactivex.rxjava3.core.Single

class ReposModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val db: DataBase
) : ReposModel {
    override fun getUserRepositories(user: User): Single<List<Repository>> {
        return if (status.isOnline()) {
            remoteService.getRepositories(user.reposUrl).flatMap { repos ->
                Single.fromCallable {
                    val roomRepos = repos.map { repo ->
                        RepoEntity(
                            repo.id,
                            repo.name,
                            repo.description,
                            repo.forksCount,
                            repo.watchersCount,
                            repo.owner.id
                        )
                    }
                    db.repoDao.insert(roomRepos)
                    repos
                }
            }
        } else {
            Single.fromCallable {
                db.repoDao.getByUserId(user.id).map { roomRepo ->
                    Repository(
                        roomRepo.id,
                        roomRepo.name,
                        roomRepo.description,
                        roomRepo.forksCount,
                        roomRepo.watchersCount,
                        RepoOwner(roomRepo.userId)
                    )
                }
            }

        }
    }
}
