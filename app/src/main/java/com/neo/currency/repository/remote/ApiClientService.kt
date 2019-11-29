package com.neo.currency.repository.remote

import com.neo.currency.repository.data.LiveCurrencyList
import com.neo.currency.repository.data.Response
import io.reactivex.Single
import retrofit2.http.*

interface ApiClientService {
    @GET("live")
    fun liveCurrency(
            @Query("access_key", encoded = true) accessKey: String
    ): Single<Response<LiveCurrencyList>>
}