package com.example.popularlibraries.model

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single

interface ReposModel {
    fun getUserRepositories(user: User): Single<List<Repository>>
}