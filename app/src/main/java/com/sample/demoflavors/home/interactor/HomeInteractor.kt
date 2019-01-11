package com.sample.demoflavors.home.interactor

import com.sample.demoflavors.api.models.CharacterModel
import io.reactivex.Observable

interface HomeInteractor {

    fun charactersResult(): Observable<CharacterModel>

}