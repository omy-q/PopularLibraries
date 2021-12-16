package com.example.popularlibraries.model

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import io.reactivex.rxjava3.core.Single

class UsersModelImplementation(
    private val status: NetworkStatus,
    private val remoteService: RetrofitService,
    private val db : DataBase
): UsersModel {

    override fun getUsers(): Single<List<User>> {
        return remoteService.getUsers()
    }
}