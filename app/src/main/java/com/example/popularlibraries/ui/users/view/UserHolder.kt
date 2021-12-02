package com.example.popularlibraries.ui.users.view

import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.databinding.ItemUsersBinding

class UserHolder(private val binding: ItemUsersBinding) :
    RecyclerView.ViewHolder(binding.root), UserItemView {
    override var pos: Int = -1
    override fun setLogin(login: String) {
        binding.userLogin.text = login
    }

}