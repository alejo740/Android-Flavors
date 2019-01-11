package com.sample.demoflavors.api.services

import com.sample.demoflavors.api.models.SearchModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApiService {

    @GET("/")
    fun getCharacters(@Query("q") query: String, @Query("format") format: String = "json"): Observable<SearchModel>

}