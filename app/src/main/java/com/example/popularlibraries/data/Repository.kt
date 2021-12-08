package com.example.popularlibraries.data

import com.google.gson.annotations.Expose

data class Repository(
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    val createDate: String,
    @Expose
    val forksCount: Int,
    @Expose
    val watchersCount: Int
)