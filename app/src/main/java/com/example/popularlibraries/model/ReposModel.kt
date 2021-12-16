package com.example.popularlibraries.model

import com.example.popularlibraries.data.Repository
import io.reactivex.rxjava3.core.Single

interface ReposModel {
    fun getUserRepositories(url: String): Single<List<Repository>>
}