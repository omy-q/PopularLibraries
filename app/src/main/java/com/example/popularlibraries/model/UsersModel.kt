package com.example.popularlibraries.model

import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Observable

interface UsersModel {
    fun getUsers(): Observable<List<User>>
}