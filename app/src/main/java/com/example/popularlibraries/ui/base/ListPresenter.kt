package com.example.popularlibraries.ui.base

interface ListPresenter<V: ItemView> {
    var itemClickListener: () -> Unit
    fun getCount(): Int
    fun bindView(view: V)
}