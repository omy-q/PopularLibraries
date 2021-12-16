package com.example.popularlibraries.remote

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {
    @GET("/users")
    fun getUsers(): Single<List<User>>
    @GET
    fun getRepositories(@Url url: String): Single<List<Repository>>
}