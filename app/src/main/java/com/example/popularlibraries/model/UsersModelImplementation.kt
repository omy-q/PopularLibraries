package com.example.popularlibraries.model

import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.model.RoomUserModel
import com.example.popularlibraries.room.users.UserEntity
import io.reactivex.rxjava3.core.Single

class UsersModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val roomModel: RoomUserModel
) : UsersModel {

    override fun getUsers(): Single<List<User>> {
        return if (status.isOnline()) {
            remoteService.getUsers().flatMap { users ->
                roomModel.saveUsers(users)
                Single.fromCallable {
                    users
                }
            }
        } else {
            roomModel.getUsers()
        }
    }

}