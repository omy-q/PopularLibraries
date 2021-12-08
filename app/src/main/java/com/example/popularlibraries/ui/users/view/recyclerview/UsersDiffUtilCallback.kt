package com.example.popularlibraries.ui.users.view.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.data.User

object UsersDiffUtilCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.login == newItem.login
    }

}