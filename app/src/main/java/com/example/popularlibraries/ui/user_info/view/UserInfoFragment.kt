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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun setLogin(login: String) {
        TODO("Not yet implemented")
    }
}