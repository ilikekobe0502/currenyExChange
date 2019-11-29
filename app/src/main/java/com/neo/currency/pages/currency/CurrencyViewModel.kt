package com.neo.currency.pages.currency

import android.app.Application
import android.util.Log
import com.neo.currency.repository.Repository
import com.neo.currency.repository.viewModel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class CurrencyViewModel(
        application: Application,
        private val compositeDisposable: CompositeDisposable,
        private val repository: Repository
) : BaseViewModel(application, compositeDisposable) {


    fun getCurrencyList() {
        compositeDisposable.add(repository.getLiveCurrencyList()
        !!.doOnSubscribe { Log.d("neo", "subscribe") }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("neo", "success = ${it}")
                }, {
                    Log.d("neo", "error = ${it.message}")
                })
        )

    }
}