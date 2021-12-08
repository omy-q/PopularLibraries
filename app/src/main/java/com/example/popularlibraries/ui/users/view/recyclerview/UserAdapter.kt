package com.example.popularlibraries.ui.users.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.popularlibraries.data.User
import com.example.popularlibraries.databinding.ItemUsersBinding

class UserAdapter(
    private val itemClickListener: (User) -> Unit
) :
    ListAdapter<User, UserHolder>(UsersDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            ItemUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        , itemClickListener)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
       holder.bind(currentList[position])
    }

}