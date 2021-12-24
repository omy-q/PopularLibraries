package com.example.popularlibraries.room.model

import com.example.popularlibraries.data.User
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.users.UserEntity
import io.reactivex.rxjava3.core.Single

class RoomUserModelImplementation(
    private val db: DataBase
) : RoomUserModel {
    override fun saveUsers(users: List<User>): Single<List<User>> {
        val roomUsers = users.map { user ->
            UserEntity(user.id, user.login, user.avatarUrl, user.reposUrl)
        }
        return db.userDao.insert(roomUsers).toSingle { users }
    }

    override fun getUsers(): Single<List<User>> {
        return db.userDao.getAll().map { listUsers ->
            listUsers.map { roomUser ->
                User(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
            }
        }
    }
}