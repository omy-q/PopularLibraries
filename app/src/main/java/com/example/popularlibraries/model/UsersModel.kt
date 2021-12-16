package com.example.popularlibraries.model

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single

interface UsersModel {
    fun getUsers(): Single<List<User>>
    fun getUserRepositories(url: String): Single<List<Repository>>
}