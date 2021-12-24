package com.example.popularlibraries.di.scope.containers

import com.example.popularlibraries.di.ReposSubcomponent

interface ReposScopeContainer {
    fun initReposSubcomponent(): ReposSubcomponent
    fun destroyReposSubcomponent()
}