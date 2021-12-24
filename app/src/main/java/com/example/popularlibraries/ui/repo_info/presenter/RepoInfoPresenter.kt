package com.example.popularlibraries.ui.repo_info.presenter

import com.example.popularlibraries.di.scope.containers.RepoInfoScopeContainer
import com.example.popularlibraries.ui.base.BasePresenter
import com.example.popularlibraries.ui.repo_info.view.RepoInfoView
import javax.inject.Inject

class RepoInfoPresenter @Inject constructor(
    private val repoInfoScopeContainer: RepoInfoScopeContainer
): BasePresenter<RepoInfoView>() {

    override fun onDestroy() {
        repoInfoScopeContainer.destroyRepoInfoSubcomponent()
        super.onDestroy()
    }
}