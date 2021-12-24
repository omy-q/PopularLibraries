package com.example.popularlibraries.room.model

import com.example.popularlibraries.data.RepoOwner
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.user_info.RepoEntity
import io.reactivex.rxjava3.core.Single

class RoomRepoModelImplementation(
    private val db: DataBase
) : RoomRepoModel {
    override fun saveUserRepos(repos: List<Repository>, userId: Int) {
        val roomRepos = repos.map { repo ->
            RepoEntity(
                repo.id,
                repo.name,
                repo.description.orEmpty(),
                repo.forksCount,
                repo.watchersCount,
                userId
            )
        }
        db.repoDao.insert(roomRepos)
    }

    override fun getUserRepos(userId: Int): Single<List<Repository>> {
        return Single.fromCallable {
            db.repoDao.getByUserId(userId).map { roomRepo ->
                Repository(
                    roomRepo.id,
                    roomRepo.name,
                    roomRepo.description,
                    roomRepo.forksCount,
                    roomRepo.watchersCount,
                    RepoOwner(userId)
                )
            }
        }
    }
}