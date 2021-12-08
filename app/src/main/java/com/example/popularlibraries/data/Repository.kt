package com.example.popularlibraries.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repository(
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("forks")
    val forksCount: Int,
    @Expose
    @SerializedName("watchers")
    val watchersCount: Int
)