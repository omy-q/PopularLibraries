package com.example.popularlibraries.di

import com.example.popularlibraries.di.scope.RepositoryInfoScope
import com.example.popularlibraries.ui.repo_info.presenter.RepoInfoPresenter
import dagger.Subcomponent

@RepositoryInfoScope
@Subcomponent(
    modules = []
)
interface RepoInfoSubcomponent {
    fun repoInfoPresenter(): RepoInfoPresenter
}