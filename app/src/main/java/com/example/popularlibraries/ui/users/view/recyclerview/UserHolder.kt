package com.example.popularlibraries.ui.users.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.popularlibraries.R
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.ItemUsersBinding

class UserHolder(
    private val binding: ItemUsersBinding,
    private val itemClickListener: (User) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User){
        binding.userView.setOnClickListener{itemClickListener(user)}
        binding.userAvatar.load(user.avatarUrl){
            transformations(CircleCropTransformation())
            placeholder(R.drawable.progress_animation)
            error(R.drawable.error_image_load)
        }
        binding.userLogin.text = user.login
        binding.userHtml.text = user.htmlUrl
    }

}