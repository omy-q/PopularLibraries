package com.example.popularlibraries.ui.user_info.view

import android.os.Bundle
import android.view.View
import com.example.popularlibraries.App
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.example.popularlibraries.ui.base.BaseFragment
import com.example.popularlibraries.ui.user_info.presenter.UserInfoPresenter
import moxy.ktx.moxyPresenter

class UserInfoFragment() : BaseFragment<FragmentUserInfoBinding>(FragmentUserInfoBinding::inflate),
    UserInfoView {

    private val presenter by moxyPresenter {
        UserInfoPresenter(App.instance.router)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = arguments?.getString(USER_LOGIN_ID).toString()
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    companion object{
        private const val USER_LOGIN_ID = "user_login_id"
        fun newInstance(login: String): UserInfoFragment{
            val args = Bundle()
            args.putString(USER_LOGIN_ID, login)
            val fragment = UserInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}