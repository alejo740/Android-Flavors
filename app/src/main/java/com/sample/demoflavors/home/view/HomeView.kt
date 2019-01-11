package com.sample.demoflavors.home.view

import com.sample.demoflavors.api.models.CharacterModel

interface HomeView {

    fun updateCharacterList(characterModel: CharacterModel)

    fun showSnackbarError(message: String)

}