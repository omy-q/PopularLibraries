package com.example.popularlibraries.ui.user_info.view

import android.os.Bundle
import android.view.View
import com.example.popularlibraries.App
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import moxy.ktx.moxyPresenter

class UserInfoFragment : BaseFragment<FragmentUserInfoBinding>(FragmentUserInfoBinding::inflate),
    UserInfoView {

    private val presenter by moxyPresenter {
        UserInfoPresenter(App.instance.router)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.let { it.getParcelable<User>(USER_ID)} as? User
        user?.let { initView(it) }
    }

    private fun initView(user : User) {
        binding.userInfoLogin.text = user.login
    }

    override fun backPressed() = presenter.backPressed()

    companion object{
        private const val USER_ID = "user_id"
        fun newInstance(user: User): UserInfoFragment{
            val args = Bundle()
            args.putParcelable(USER_ID, user)
            val fragment = UserInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}