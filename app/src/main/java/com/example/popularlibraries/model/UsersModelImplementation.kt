package com.example.popularlibraries.model

import com.example.popularlibraries.data.User

class UsersModelImplementation: UsersModel {
    private var users = listOf(
        User("login1"),
        User("login2"),
        User("login3"),
        User("login4"),
        User("login5"),
        User("login6")
    )
    override fun getUsers(): List<User> {
        return users
    }
}