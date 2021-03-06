package com.example.popularlibraries.ui.users.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.App
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.users.view.recyclerview.UserAdapter
import moxy.ktx.moxyPresenter

class UsersFragment : BaseFragment<FragmentUsersBinding>(FragmentUsersBinding::inflate), UsersView {

    private val presenter by moxyPresenter {
        App.instance.initUsersSubcomponent()
        App.instance.usersSubcomponent?.usersPresenter()!!
    }

    private val adapter by lazy {
        UserAdapter(presenter::onItemClicked)
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