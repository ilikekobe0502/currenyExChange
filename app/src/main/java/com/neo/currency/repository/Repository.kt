package com.neo.currency.repository

import android.app.Application
import com.google.gson.Gson
import com.neo.currency.repository.data.LiveCurrencyList
import com.neo.currency.repository.data.Response
import com.neo.currency.repository.provider.preferences.PreferencesKey.TOKEN
import com.neo.currency.repository.provider.preferences.SharedPreferencesProvider
import com.neo.currency.repository.remote.RemoteAPI
import com.neo.currency.repository.remote.ApiClient
import io.reactivex.Single

class Repository(
        private var application: Application,
        private val sharedPreferencesProvider: SharedPreferencesProvider
) {

    val TAG = Repository::class.simpleName

    val mGson: Gson = Gson()

    init {
        RemoteAPI.init(application)
    }

    /*
        Remote API
     */

    fun getLiveCurrencyList(): Single<Response<LiveCurrencyList>>? {
        return ApiClient.getInstance()!!.getLiveCurrencyList()
    }


    /*
        Local
     */

    /**
     * 暫存 User 資料
     */
    fun saveToken(token: String) {
        sharedPreferencesProvider.sharedPreferences().edit().putString(TOKEN, token).apply()
    }

    /**
     * 取得 User 資料
     */
    fun getToken(): Single<String> {
        return Single.fromCallable { sharedPreferencesProvider.sharedPreferences().getString(TOKEN, "") }
    }
}