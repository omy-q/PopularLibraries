package com.example.popularlibraries.ui.user_info.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.databinding.ItemRepositoryBinding

class RepositoryAdapter(private val itemClickListener: (Repository) -> Unit
) :
    ListAdapter<Repository, RepositoryHolder>(RepositoryDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryHolder {
        return RepositoryHolder(
            ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            , itemClickListener)
    }

    override fun onBindViewHolder(holder: RepositoryHolder, position: Int) {
        holder.bind(currentList[position])
    }
}