package com.sample.demoflavors.home.presenter

import com.sample.demoflavors.api.models.CharacterModel
import com.sample.demoflavors.home.interactor.HomeInteractor
import com.sample.demoflavors.home.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class HomePresenterImpl(private val interactor: HomeInteractor) : HomePresenter {

    private var subscription: Disposable? = null
    private lateinit var view: HomeView

    override fun loadData() {
        subscription = interactor.charactersResult()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<CharacterModel>() {
                override fun onComplete() {
                    view.showSnackbarError("Excellent!!!!")
                }

                override fun onNext(t: CharacterModel) {
                    view.updateCharacterList(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    view.showSnackbarError("Error getting products")
                }
            })
    }

    override fun rxUnsubscribe() {
        subscription!!.let {
            if(it.isDisposed)
                it.dispose()
        }
    }

    override fun setView(view: HomeView) {
        this.view = view
    }
}