package com.example.popularlibraries.ui.users.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.App
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.model.UsersModelImplementation
import com.example.popularlibraries.remote.ApiHolder
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.users.presenter.UsersPresenter
import com.example.popularlibraries.ui.users.view.recyclerview.UserAdapter
import moxy.ktx.moxyPresenter

class UsersFragment : BaseFragment<FragmentUsersBinding>(FragmentUsersBinding::inflate), UsersView {

    private val presenter by moxyPresenter {
        UsersPresenter(App.instance.router,
            UsersModelImplementation(
                status = status,
                remoteService = ApiHolder.retrofitService,
                db = DataBase.instance
            )
        )
    }

    private val adapter by lazy {
        UserAdapter(presenter::onItemClicked)
    }

    private val status by lazy {
        NetworkStatus(requireContext().applicationContext)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun backPressed() = presenter.backPressed()

    private fun initView() {
        with(binding) {
            usersList.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            usersList.adapter = adapter
        }
    }

    override fun updateUsers(users: List<User>) {
        adapter.submitList(users)
    }

    override fun hideLoading() {
        binding.usersList.isVisible = true
        binding.loading.isVisible = false
    }

    override fun showLoading() {
        binding.usersList.isVisible = false
        binding.loading.isVisible = true
    }
}