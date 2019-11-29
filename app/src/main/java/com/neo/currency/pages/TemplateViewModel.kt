package com.neo.currency.pages

import android.app.Application
import com.neo.currency.repository.Repository
import com.neo.currency.repository.viewModel.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

class TemplateViewModel(
    application: Application,
    private val compositeDisposable: CompositeDisposable,
    private val repository: Repository
) : BaseViewModel(application, compositeDisposable) {


}