package com.sample.demoflavors.home.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.transition.Explode
import android.view.*
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.app.App
import com.sample.demoflavors.detail.view.ARG_CHARACTER
import com.sample.demoflavors.detail.view.DetailActivity
import com.sample.demoflavors.detail.view.DetailFragment
import com.sample.demoflavors.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    private val gridLayout = GridLayoutManager(this, 1)

    private lateinit var adapterCharacterList: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                exitTransition = Explode()
                exitTransition.duration = 800
            }
        }

        setContentView(R.layout.activity_main)

        (application as App).component!!.let { it.inject(this) }
        setupList()

        presenter.setView(this)
        presenter.loadData()
    }

    private fun setupList() {
        item_list.layoutManager = gridLayout
        item_list.setHasFixedSize(true)
        adapterCharacterList =
                CharacterListAdapter { characterModel, view -> openCharacterDetail(characterModel, view) }
        item_list.adapter = adapterCharacterList
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
        if (gridLayout.spanCount == 1) {
            adapterCharacterList.linearView = false
            gridLayout.spanCount = 2
        } else {
            adapterCharacterList.linearView = true
            gridLayout.spanCount = 1
        }
        item_list.adapter = adapterCharacterList
        item_list.scrollToPosition(scrollPos)
    }

    private fun openCharacterDetail(
        characterModel: CharacterModel,
        view: View
    ) {
        if (detail_container == null) {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(ARG_CHARACTER, characterModel)
            }


            if (gridLayout.spanCount == 2) {
                var options: ActivityOptions? = null
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(
                        this,
                        view.image_view,
                        getString(R.string.image_transition_name)
                    )
                }
                startActivity(intent, options?.toBundle())
            }else{
                startActivity(intent)
                overridePendingTransition(R.anim.right_in, R.anim.left_out)
            }


        } else {
            val fragment = DetailFragment.newInstance(characterModel, false)
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.detail_container, fragment)
                .commit()
        }
    }

    override fun updateCharacterList(characterModel: CharacterModel) {
        adapterCharacterList.addCharacter(characterModel)
    }

    override fun showSnackbarError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }
}
