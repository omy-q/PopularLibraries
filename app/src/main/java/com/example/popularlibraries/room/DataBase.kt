package com.example.popularlibraries.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popularlibraries.room.user_info.RepoDao
import com.example.popularlibraries.room.user_info.RepoEntity
import com.example.popularlibraries.room.users.UserDao
import com.example.popularlibraries.room.users.UserEntity

@Database(
    entities = [
        UserEntity::class,
        RepoEntity::class
    ], version = 1
)
abstract class DataBase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repoDao: RepoDao
}