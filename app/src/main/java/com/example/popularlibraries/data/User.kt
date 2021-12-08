package com.example.popularlibraries.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Expose
    val id: Int,
    @Expose
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @Expose
    @SerializedName("repos_url")
    val reposUrl: String
) : Parcelable
