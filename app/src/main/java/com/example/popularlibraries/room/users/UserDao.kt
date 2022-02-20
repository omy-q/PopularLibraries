package com.example.popularlibraries.room.users

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<UserEntity>): Completable

    @Update
    fun update(user: UserEntity): Completable

    @Delete
    fun delete(user: UserEntity): Completable

    @Query("SELECT * FROM UserEntity")
    fun getAll(): Single<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE login = :login LIMIT 1")
    fun getByLogin(login: String): Maybe<UserEntity>

}