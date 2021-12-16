package com.example.popularlibraries.room.user_info

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RepoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RepoEntity>)

    @Query("SELECT * FROM RepoEntity")
    fun getAll(): List<RepoEntity>

    @Query("SELECT * FROM RepoEntity WHERE userId = :userId")
    fun getByUserId(userId: String): List<RepoEntity>
}