package com.mvvm.kotlin

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mvvm.kotlin.pages.TemplateFragment
import com.mvvm.kotlin.pages.TemplateViewModel
import com.mvvm.kotlin.repository.Repository
import com.mvvm.kotlin.repository.provider.preferences.SharedPreferencesProvider
import com.mvvm.kotlin.repository.provider.resource.ResourceProvider
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

                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            } as T
        }
    }
}