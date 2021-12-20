package com.example.popularlibraries.navigation

import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.ui.repo_info.view.RepoInfoFragment
import com.example.popularlibraries.ui.user_info.view.UserInfoFragment
import com.example.popularlibraries.ui.users.view.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreensImplementation : Screens {
    override fun users() = FragmentScreen { UsersFragment() }
    override fun userInfo(user: User) = FragmentScreen { UserInfoFragment.newInstance(user) }
    override fun repoInfo(repository: Repository) = FragmentScreen {
        RepoInfoFragment.newInstance(repository)
    }
}


