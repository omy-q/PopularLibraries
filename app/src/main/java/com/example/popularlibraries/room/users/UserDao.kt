package com.example.popularlibraries.room.users

import androidx.room.*
import com.example.popularlibraries.room.user_info.RepoEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<UserEntity>)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE login = :login LIMIT 1")
    fun getByLogin(login: String): UserEntity?

}