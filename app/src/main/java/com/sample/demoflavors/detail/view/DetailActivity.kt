package com.sample.demoflavors.detail.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailActivity : AppCompatActivity(), DetailBase {

    override var character: CharacterModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        character = intent.getSerializableExtra(ARG_CHARACTER) as CharacterModel
        title = character?.title
        setupView(description_view, image_view)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
