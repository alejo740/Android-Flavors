package com.sample.demoflavors.app

import com.sample.demoflavors.api.services.CharactersApiModule
import com.sample.demoflavors.home.di.HomeModule
import com.sample.demoflavors.home.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, HomeModule::class, CharactersApiModule::class])
interface ApplicationComponent {

    fun inject(target: MainActivity)

}