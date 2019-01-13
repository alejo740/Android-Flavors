package com.sample.demoflavors.api.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    var title: String?,
    var description: String?,
    var photoUrl: String?
) : java.io.Serializable