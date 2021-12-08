package com.example.popularlibraries.ui.user_info.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.data.Repository
import com.example.popularlibraries.databinding.ItemRepositoryBinding

class RepositoryHolder (
    private val binding: ItemRepositoryBinding,
    private val itemClickListener: (Repository) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(repo: Repository){
        binding.repBtnInfo.setOnClickListener { itemClickListener }
        binding.repName.text = repo.name
        binding.repCreateDate.text = repo.createDate
    }
}