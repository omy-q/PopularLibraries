package com.example.popularlibraries.ui.user_info.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.example.popularlibraries.App
import com.example.popularlibraries.R
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.example.popularlibraries.model.ReposModelImplementation
import com.example.popularlibraries.model.UsersModelImplementation
import com.example.popularlibraries.remote.ApiHolder
import com.example.popularlibraries.remote.connectivity.NetworkStatus
import com.example.popularlibraries.room.DataBase
import com.example.popularlibraries.room.model.RoomRepoModelImplementation
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import com.example.popularlibraries.ui.user_info.view.recyclerview.RepositoryAdapter
import moxy.ktx.moxyPresenter

class UserInfoFragment : BaseFragment<FragmentUserInfoBinding>(FragmentUserInfoBinding::inflate),
    UserInfoView {

    private val presenter by moxyPresenter {
        UserInfoPresenter(
            ReposModelImplementation(
                status = status,
                remoteService = ApiHolder.retrofitService,
                roomModel = RoomRepoModelImplementation(DataBase.instance)
            )
        )
    }
    private val status by lazy {
        NetworkStatus(requireContext().applicationContext)
    }

    private val adapter by lazy {
        RepositoryAdapter(presenter::onItemClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.let { it.getParcelable<User>(USER_ID) }
        user?.let { presenter.getData(it) }
        initView()
    }

    private fun initView() {
        binding.userRepositories.layoutManager = GridLayoutManager(context, 3)
        binding.userRepositories.adapter = adapter
    }

    override fun setData(user: User) {
        binding.userInfoAvatar.load(user.avatarUrl) {
            transformations(CircleCropTransformation())
            placeholder(R.drawable.progress_animation)
            error(R.drawable.error_image_load)
        }
        binding.userInfoLogin.text = user.login
    }

    override fun updateRepositories(reps: List<Repository>) {
        adapter.submitList(reps)
    }

    override fun hideLoading() {
        binding.userRepositories.isVisible = true
        binding.loading.isVisible = false
    }

    override fun showLoading() {
        binding.userRepositories.isVisible = false
        binding.loading.isVisible = true
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER_ID = "user_id"
        fun newInstance(user: User): UserInfoFragment {
            val args = Bundle()
            args.putParcelable(USER_ID, user)
            val fragment = UserInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}