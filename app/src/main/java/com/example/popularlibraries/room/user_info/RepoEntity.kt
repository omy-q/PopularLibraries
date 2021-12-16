package com.example.popularlibraries.room.user_info

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.popularlibraries.room.users.UserEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RepoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val forksCount: Int,
    val watchersCount: Int,
    val userId: Int,
)