package com.neo.currency.repository.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Response<T>(
        @SerializedName("data")
        var data: T? = null,
        @SerializedName("success")
        var success: Boolean,
        @SerializedName("terms")
        var terms: String?,
        @SerializedName("privacy")
        var privacy: String?

) : Serializable

data class LiveCurrencyList(
        var timestamp: Long,
        var source: String?,
        var quotes: HashMap<String, Int>?
) : Serializable