package com.sample.demoflavors.api.services

import com.sample.demoflavors.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class CharactersApiModule {

    @Provides
    fun provideRetrofit(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(): CharactersApiService {
        return provideRetrofit(BuildConfig.BASE_URL).create(CharactersApiService::class.java)
    }
}