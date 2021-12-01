package com.example.popularlibraries.navigation

import com.example.popularlibraries.ui.users.view.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun users() = FragmentScreen{UsersFragment()}
}