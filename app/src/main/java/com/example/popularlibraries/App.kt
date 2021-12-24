package com.example.popularlibraries

import android.app.Application
import com.example.popularlibraries.di.AppComponent
import com.example.popularlibraries.di.DaggerAppComponent
import com.example.popularlibraries.di.modules.ContextModule

class App: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object{
        private var _instance: App? = null
        val instance get() = _instance!!
    }
}