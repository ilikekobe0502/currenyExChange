package com.mvvm.kotlin

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mvvm.kotlin.repository.Repository
import com.mvvm.kotlin.repository.provider.preferences.SharedPreferencesProvider
import com.mvvm.kotlin.repository.provider.resource.ResourceProvider

object AppInjector {

    lateinit var application: Application private set
    lateinit var viewModelFactory: ViewModelFactory private set
    lateinit var repository: Repository private set
    lateinit var preferences: SharedPreferencesProvider private set
    lateinit var resource: ResourceProvider private set

    fun init(application: Application) {
        this.application = application


        preferences = SharedPreferencesProvider(this.application)
        resource = ResourceProvider(this.application)
        repository = Repository(this.application, preferences)

        viewModelFactory = ViewModelFactory(application, repository, preferences, resource)
    }

    inline fun <reified T : ViewModel> obtainViewModel(activity: Activity): T =
        ViewModelProviders.of(activity as AppCompatActivity, viewModelFactory).get(T::class.java)

    inline fun <reified T : ViewModel> obtainViewModel(fragment: Fragment): T =
        ViewModelProviders.of(fragment, viewModelFactory).get(T::class.java)

}