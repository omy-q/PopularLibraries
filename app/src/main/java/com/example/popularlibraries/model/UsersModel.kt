package com.example.popularlibraries.model

import com.example.popularlibraries.data.User

interface UsersModel {
    fun getUsers(): List<User>
}