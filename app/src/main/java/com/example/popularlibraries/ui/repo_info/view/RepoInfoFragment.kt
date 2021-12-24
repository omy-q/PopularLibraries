package com.example.popularlibraries.ui.repo_info.view

import android.os.Bundle
import android.view.View
import com.example.popularlibraries.App
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.databinding.FragmentRepoInfoBinding
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.repo_info.presenter.RepoInfoPresenter
import moxy.ktx.moxyPresenter

class RepoInfoFragment() : BaseFragment<FragmentRepoInfoBinding>(FragmentRepoInfoBinding::inflate),
    RepoInfoView {

    private val presenter by moxyPresenter {
        RepoInfoPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = arguments?.getParcelable(REPO_ID) as? Repository
        repository?.let { initView(it) }
    }

    private fun initView(repository: Repository) {
        binding.repoName.text = repository.name
        binding.forksCount.text = repository.forksCount.toString()
        binding.watchersCount.text = repository.watchersCount.toString()
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val REPO_ID = "repo_id"
        fun newInstance(repository: Repository): RepoInfoFragment {
            val args = Bundle()
            args.putParcelable(REPO_ID, repository)
            val fragment = RepoInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}