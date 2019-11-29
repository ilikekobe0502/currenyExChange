package com.neo.currency.repository.remote

import com.neo.currency.repository.data.LiveCurrencyList
import com.neo.currency.repository.data.Response
import com.neo.currency.repository.remote.RemoteAPI.Companion.getOkHttpClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val API_KEY_CURRENCY_LAYER = "2304da34118d136ed0f18bfad46504ed"

    companion object {
        private val TAG = ApiClient::class.simpleName
        private var sInstance: ApiClient? = null
        private lateinit var mService: ApiClientService

        //一頁的listView顯示幾個，之後應由後台做設定
        private const val LISTVIEW_PAGECOUNT = 10

        fun getInstance(): ApiClient? {
            if (sInstance == null) {
                synchronized(ApiClient::class) {
                    if (sInstance == null) {
                        sInstance = ApiClient()
                    }
                }
            }
            return sInstance
        }
    }

    init {
        val url = "http://apilayer.net/api/"
        val client = getOkHttpClient()

        val retrofit = Retrofit.Builder()
                .baseUrl(HttpUrl.get(url))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

        mService = retrofit.create(ApiClientService::class.java)
    }


    /*--------------------------------------------------------------------------------------------*/
    /* APIs */

    fun getLiveCurrencyList(): Single<Response<LiveCurrencyList>> {
        return mService.liveCurrency(API_KEY_CURRENCY_LAYER)
    }
}