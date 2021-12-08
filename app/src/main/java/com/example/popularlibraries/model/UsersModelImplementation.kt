package com.example.popularlibraries.model

import com.example.popularlibraries.data.User
import com.example.popularlibraries.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class UsersModelImplementation(
    private val remoteService: RetrofitService
): UsersModel {

    override fun getUsers(): Single<List<User>> {
        return remoteService.getUsers()
    }
}