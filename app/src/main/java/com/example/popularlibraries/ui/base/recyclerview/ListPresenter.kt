package com.example.popularlibraries.ui.base.recyclerview

interface ListPresenter<V: ItemView> {
    var itemClickListener: (pos: Int) -> Unit
    fun getCount(): Int
    fun bindView(view: V)
}