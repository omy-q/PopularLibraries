package com.example.popularlibraries.room.user_info

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RepoEntity) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RepoEntity>) : Completable

    @Query("SELECT * FROM RepoEntity")
    fun getAll(): Single<List<RepoEntity>>

    @Query("SELECT * FROM RepoEntity WHERE userId = :userId")
    fun getByUserId(userId: Int): Single<List<RepoEntity>>
}