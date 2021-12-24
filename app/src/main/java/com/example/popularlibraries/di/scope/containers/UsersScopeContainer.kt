package com.example.popularlibraries.di.scope.containers

import com.example.popularlibraries.di.UsersSubcomponent

interface UsersScopeContainer {
    fun initUsersSubcomponent(): UsersSubcomponent
    fun destroyUsersSubcomponent()
}