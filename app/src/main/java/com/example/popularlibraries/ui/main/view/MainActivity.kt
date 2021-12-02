package com.example.popularlibraries.ui.main.view

import android.os.Bundle
import com.example.popularlibraries.App
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.ui.base.BackButtonListener
import com.example.popularlibraries.ui.main.presenter.MainPresenter
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backPressed()
    }
}