package com.example.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.presenter.MainPresenter
import com.example.popularlibraries.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initBtnListener()
    }

    private fun initView() {
        presenter.initView()
    }

    private fun initBtnListener() {
        binding.btnCounter1.setOnClickListener {
            presenter.onFirstBtnClicked()
        }
        binding.btnCounter2.setOnClickListener {
            presenter.onSecondBtnClicked()
        }
        binding.btnCounter3.setOnClickListener {
            presenter.onThirdBtnClicked()
        }
    }

    override fun setFirstBtnText(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setSecondBtnText(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setThirdBtnText(text: String) {
        binding.btnCounter3.text = text
    }
}