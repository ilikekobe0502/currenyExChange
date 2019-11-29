package com.neo.currency.constants

import android.os.Bundle
import android.support.v4.app.Fragment
import com.neo.currency.pages.TemplateFragment
import com.neo.currency.pages.currency.CurrencyFragment
import java.lang.IllegalArgumentException

object Page {

    const val PAGE = "page"
    const val ARG_PAGE = "com.neo.goservice.constants.Page.ARG_PAGE"
    const val ARG_DATA = "com.neo.goservice.constants.Page.ARG_DATA"

    const val INVALID_PAGE = -1

    const val TEMPLATE = 1000
    const val CURRENCY_EXANGE = 1001

    /*--------------------------------------------------------------------------------------------*/
    /* Helpers */
    fun tag(page: Int): String = "page_$page"

    fun view(page: Int, args: Bundle): Fragment {
        var result: Fragment

        when (page) {
            TEMPLATE -> result = TemplateFragment.newInstance()
            CURRENCY_EXANGE -> result = CurrencyFragment.newInstance()
            else -> throw IllegalArgumentException("No match view! page = $page")
        }

        args.putInt(ARG_PAGE, page)
        putData(result, args)

        return result
    }

    private fun putData(fragment: Fragment, data: Bundle) {
        var args = fragment.arguments;
        if (args == null) {
            fragment.arguments = data
        } else {
            args.putAll(data)
        }
    }
}