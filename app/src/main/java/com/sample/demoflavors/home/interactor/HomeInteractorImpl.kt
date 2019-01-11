package com.sample.demoflavors.home.interactor

import com.sample.demoflavors.BuildConfig
import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.api.services.CharactersApiService
import io.reactivex.Observable

class HomeInteractorImpl(private val charactersApiService: CharactersApiService) : HomeInteractor {

    override fun charactersResult(): Observable<CharacterModel> {
        return charactersApiService.getCharacters(BuildConfig.CHARACTERS_QUERY)
            .flatMap { Observable.fromIterable(it.relatedTopics) }
            .map{
                val split = it.text!!.split(Regex("-"), 2)
                val title = split.firstOrNull()
                val description = split.last()
                val photoUrl = it.icon!!.url
                CharacterModel(title, description, photoUrl) }
    }

}