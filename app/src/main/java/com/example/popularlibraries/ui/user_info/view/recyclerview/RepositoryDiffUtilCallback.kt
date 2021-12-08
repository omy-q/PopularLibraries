package com.example.popularlibraries.ui.user_info.view.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.data.Repository

object RepositoryDiffUtilCallback : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.forksCount == newItem.forksCount &&
                oldItem.watchersCount == newItem.watchersCount
    }

}