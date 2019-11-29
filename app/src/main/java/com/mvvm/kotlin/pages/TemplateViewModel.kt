package com.mvvm.kotlin.pages

import android.app.Application
import com.mvvm.kotlin.repository.Repository
import com.mvvm.kotlin.repository.viewModel.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

class TemplateViewModel(
    application: Application,
    private val compositeDisposable: CompositeDisposable,
    private val repository: Repository
) : BaseViewModel(application, compositeDisposable) {


}