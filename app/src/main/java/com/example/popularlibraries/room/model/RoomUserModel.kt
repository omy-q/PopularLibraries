package com.example.popularlibraries.room.model

import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single

interface RoomUserModel {
    fun saveUsers(users: List<User>)
    fun getUsers(): Single<List<User>>
}