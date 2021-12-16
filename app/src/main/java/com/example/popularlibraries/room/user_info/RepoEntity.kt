package com.example.popularlibraries.room.user_info

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class RepoEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val forksCount: Int,
    val watchersCount: Int,
    val userId: String,
)