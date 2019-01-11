package com.sample.demoflavors.home.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.app.App
import com.sample.demoflavors.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    private val gridLayout = GridLayoutManager(this, 1)

    private lateinit var adapterCharacterList: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).component!!.let { it.inject(this) }
        setupList()
    }

    private fun setupList() {
        item_list.layoutManager = gridLayout
        item_list.setHasFixedSize(true)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.toggle_view -> {
                toggleView()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleView() {
        val scrollPos = (item_list.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        if(gridLayout.spanCount == 1) {
            adapterCharacterList.linearView = false
            gridLayout.spanCount = 2
        }else{
            adapterCharacterList.linearView = true
            gridLayout.spanCount = 1
        }
        item_list.adapter = adapterCharacterList
        item_list.scrollToPosition(scrollPos)
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
