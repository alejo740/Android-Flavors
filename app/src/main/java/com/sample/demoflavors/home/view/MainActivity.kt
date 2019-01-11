package com.sample.demoflavors.home.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.app.App
import com.sample.demoflavors.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    private lateinit var adapterCharacterList: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).component!!.let { it.inject(this) }
        setupList()
    }

    private fun setupList() {
        item_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        adapterCharacterList = CharacterListAdapter { characterModel -> openCharacterDetail(characterModel) }
        item_list.adapter = adapterCharacterList
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
        presenter.loadData()
    }

    override fun onPause() {
        super.onPause()
        presenter.rxUnsubscribe()
    }

    private fun openCharacterDetail(characterModel: CharacterModel) {

    }

    override fun updateCharacterList(characterModel: CharacterModel) {
        adapterCharacterList.addCharacter(characterModel)
    }

    override fun showSnackbarError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }
}
