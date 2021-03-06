package com.example.popularlibraries.room.model

import com.example.popularlibraries.data.RepoOwner
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.user_info.RepoEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomRepoModelImplementation @Inject constructor(
    private val db: DataBase
) : RoomRepoModel {
    override fun saveUserRepos(repos: List<Repository>): Single<List<Repository>> {
        val roomRepos = repos.map { repo ->
            RepoEntity(
                repo.id,
                repo.name,
                repo.description.orEmpty(),
                repo.forksCount,
                repo.watchersCount,
                repo.owner.id
            )
        }
        return db.repoDao.insert(roomRepos).toSingle { repos }
    }

    override fun getUserRepos(userId: Int): Single<List<Repository>> {
        return db.repoDao.getByUserId(userId).map { list ->
            list.map { roomRepo ->
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