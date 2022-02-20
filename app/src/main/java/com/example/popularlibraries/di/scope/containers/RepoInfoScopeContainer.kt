package com.example.popularlibraries.di.scope.containers

import com.example.popularlibraries.di.RepoInfoSubcomponent
import com.example.popularlibraries.di.ReposSubcomponent

interface RepoInfoScopeContainer {
    fun initRepoInfoSubcomponent(): RepoInfoSubcomponent
    fun destroyRepoInfoSubcomponent()
}