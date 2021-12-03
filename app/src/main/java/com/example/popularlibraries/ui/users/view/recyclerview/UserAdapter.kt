package com.example.popularlibraries.ui.users.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.databinding.ItemUsersBinding
import com.example.popularlibraries.ui.users.presenter.UserListPresenter

class UserAdapter(private val presenter: UserListPresenter) :
    RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            ItemUsersBinding.inflate(
                (LayoutInflater.from(parent.context)), parent, false)).apply {
                    itemView.setOnClickListener {
                        presenter.itemClickListener(pos)
                    }
        }
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }
}