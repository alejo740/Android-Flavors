package com.sample.demoflavors.detail.view

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.home.view.CharacterListAdapter

interface DetailBase {

    var character: CharacterModel?

    fun setupView(descriptionView: TextView, imageView: ImageView) {
        descriptionView.text = character?.description

        Glide.with(imageView.context)
            .load(character?.photoUrl)
            .apply(CharacterListAdapter.imageOptions)
            .into(imageView)
    }

}