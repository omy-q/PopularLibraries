package com.example.popularlibraries.room.model

import com.example.popularlibraries.data.Repository
import io.reactivex.rxjava3.core.Single

interface RoomRepoModel {
    fun saveUserRepos(repos: List<Repository>) : Single<List<Repository>>
    fun getUserRepos(userId: Int) : Single<List<Repository>>
}