package com.sample.demoflavors.home.presenter

import com.sample.demoflavors.home.view.HomeView

interface HomePresenter {

    fun loadData()

    fun rxUnsubscribe()

    fun setView(view: HomeView)

}