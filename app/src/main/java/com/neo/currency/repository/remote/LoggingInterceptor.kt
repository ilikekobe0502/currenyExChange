package com.neo.currency.repository.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody

class LoggingInterceptor : Interceptor {

    companion object {
        private val TAG = LoggingInterceptor::class.java.simpleName
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()

        val t1 = System.nanoTime()
        Log.d(TAG, String.format("Sending request %s on %s%n%s",
                request?.url(), chain?.connection(), request?.headers()))

        val response = chain?.proceed(request)

        val t2 = System.nanoTime()
        Log.d(TAG, String.format("Received response for %s in %.1fms%n%s",
                response?.request()?.url(), (t2 - t1) / 1e6, request?.headers()))


        val responseString = response?.body()?.string()
        Log.d(TAG, "Response string = $responseString")
        return response?.newBuilder()
                ?.body(ResponseBody.create(response.body()?.contentType(), responseString))?.build()!!
    }
}