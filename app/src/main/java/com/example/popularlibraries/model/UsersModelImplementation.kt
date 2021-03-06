package com.example.popularlibraries.model

import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.model.RoomUserModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UsersModelImplementation @Inject constructor(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val roomModel: RoomUserModel
) : UsersModel {

    override fun getUsers(): Single<List<User>> {
        return if (status.isOnline()) {
            remoteService.getUsers().flatMap(roomModel::saveUsers)
        } else {
            roomModel.getUsers()
        }
    }
}