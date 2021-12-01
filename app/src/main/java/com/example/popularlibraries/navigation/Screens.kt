package com.example.popularlibraries.navigation

import com.example.popularlibraries.ui.users.view.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun users() = FragmentScreen{UserFragment()}
}