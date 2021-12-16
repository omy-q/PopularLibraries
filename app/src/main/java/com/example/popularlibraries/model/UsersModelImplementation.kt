package com.example.popularlibraries.model

import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.users.UserEntity
import io.reactivex.rxjava3.core.Single

class UsersModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val db: DataBase
) : UsersModel {

    override fun getUsers(): Single<List<User>> {
        return if (status.isOnline()) {
            remoteService.getUsers().flatMap { users ->
                Single.fromCallable {
                    val roomUsers = users.map { user ->
                        UserEntity(user.id, user.login, user.avatarUrl, user.reposUrl)
                    }
                    db.userDao.insert(roomUsers)
                    users
                }
            }
        } else {
            Single.fromCallable {
                db.userDao.getAll().map { roomUser ->
                    User(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
                }
            }
        }
    }

}