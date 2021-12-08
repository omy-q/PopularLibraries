package com.example.popularlibraries.remote

import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("/users")
    fun getUsers(): Single<List<User>>
}