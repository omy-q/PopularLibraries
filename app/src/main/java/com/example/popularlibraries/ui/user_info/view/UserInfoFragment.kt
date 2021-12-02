package com.example.popularlibraries.ui.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import moxy.MvpAppCompatFragment

class UserInfoFragment():MvpAppCompatFragment(), UserInfoView {
    private var _binding : FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

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


    override fun setLogin(login: String) {
        TODO("Not yet implemented")
    }
}