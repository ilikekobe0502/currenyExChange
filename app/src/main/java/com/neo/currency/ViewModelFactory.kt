package com.neo.currency

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.neo.currency.pages.TemplateFragment
import com.neo.currency.pages.TemplateViewModel
import com.neo.currency.pages.currency.CurrencyFragment
import com.neo.currency.pages.currency.CurrencyViewModel
import com.neo.currency.repository.Repository
import com.neo.currency.repository.provider.preferences.SharedPreferencesProvider
import com.neo.currency.repository.provider.resource.ResourceProvider
import io.reactivex.disposables.CompositeDisposable


class ViewModelFactory(private val application: Application,
                       private val repository: Repository,
                       private val preferences: SharedPreferencesProvider,
                       private val resource: ResourceProvider
) : ViewModelProvider.NewInstanceFactory() {

    //ViewModel需要的model再打進去

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(TemplateFragment::class.java) -> TemplateViewModel(application, CompositeDisposable(), repository)
                isAssignableFrom(CurrencyViewModel::class.java) -> CurrencyViewModel(application, CompositeDisposable(), repository)

                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            } as T
        }
    }
}