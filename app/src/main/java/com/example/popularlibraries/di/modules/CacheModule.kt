package com.example.popularlibraries.di.modules

import android.content.Context
import androidx.room.Room
import com.example.popularlibraries.room.DataBase
import dagger.Provides

private const val DB_NAME = "database.db"

class CacheModule {

    @Provides
    fun db(context: Context) =
        Room
            .databaseBuilder(context, DataBase::class.java, DB_NAME)
            .build()

}