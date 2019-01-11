package com.sample.demoflavors.home.di

import com.sample.demoflavors.api.services.CharactersApiService
import com.sample.demoflavors.home.interactor.HomeInteractor
import com.sample.demoflavors.home.interactor.HomeInteractorImpl
import com.sample.demoflavors.home.presenter.HomePresenter
import com.sample.demoflavors.home.presenter.HomePresenterImpl
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideMainActivityHomePresenter(interactor: HomeInteractor): HomePresenter {
        return HomePresenterImpl(interactor)
    }

    @Provides
    fun provideMainActivityInteractor(productsApiService: CharactersApiService): HomeInteractor {
        return HomeInteractorImpl(productsApiService)
    }

}