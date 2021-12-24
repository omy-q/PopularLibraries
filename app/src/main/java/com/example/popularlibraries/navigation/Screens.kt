package com.example.popularlibraries.navigation

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface Screens {
    fun users() : FragmentScreen
    fun userInfo(user: User) : FragmentScreen
    fun repoInfo(repository: Repository) : FragmentScreen
}
