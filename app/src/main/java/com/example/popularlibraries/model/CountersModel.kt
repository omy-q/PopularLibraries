package com.example.popularlibraries.model

class CountersModel {

    val counters = mutableListOf(0, 0, 0)

    fun incrementCounter(id: Int) {
        counters[id]++
    }

    fun getCounterValue(id: Int): Int {
        return counters[id]
    }
}