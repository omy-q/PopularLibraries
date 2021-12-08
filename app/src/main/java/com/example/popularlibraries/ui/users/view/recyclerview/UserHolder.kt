package com.example.popularlibraries.ui.users.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.ItemUsersBinding

class UserHolder(
    private val binding: ItemUsersBinding,
    private val itemClickListener: (User) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User){
        binding.userView.setOnClickListener{itemClickListener(user)}
        binding.userLogin.text = user.login
    }

}