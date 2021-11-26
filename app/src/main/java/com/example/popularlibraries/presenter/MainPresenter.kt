package com.example.popularlibraries.presenter

import com.example.popularlibraries.model.CountersModel
import com.example.popularlibraries.view.MainView

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun initView(){
        view.setFirstBtnText(model.getCounterValue(0).toString())
        view.setSecondBtnText(model.getCounterValue(1).toString())
        view.setThirdBtnText(model.getCounterValue(2).toString())
    }

    fun onFirstBtnClicked(){
        model.incrementCounter(0)
        view.setFirstBtnText(model.getCounterValue(0).toString())
    }
    fun onSecondBtnClicked(){
        model.incrementCounter(1)
        view.setSecondBtnText(model.getCounterValue(1).toString())
    }
    fun onThirdBtnClicked(){
        model.incrementCounter(2)
        view.setThirdBtnText(model.getCounterValue(2).toString())

    }

}