package com.neo.currency.pages

import android.os.Bundle
import com.neo.currency.R
import com.neo.currency.constants.Page
import com.neo.currency.pages.base.OnPageInteractionListener
import com.neo.currency.pages.base.PaneViewActivity

class MainActivity : PaneViewActivity(), OnPageInteractionListener.Primary {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        var intent = intent

        var args = intent.extras
        var page = args?.getInt("page")
//        intent?.let {
//            page = it.getIntExtra(PAGE,page)
//            args = it.getBundleExtra(EX)
//        }
//        switchPage(page, args)
        switchPage(R.id.fragment_container, Page.CURRENCY_EXANGE, Bundle(), true, false)
    }

    private fun init() {

    }

//    /**
//     * 切換頁面
//     * @page 傳進來的page代號
//     * @bundle 需要傳遞的bundle
//     */
//    private fun switchPage(page: Int, bundle: Bundle) {
//        when (page) {
//            Page.NEWS -> setButtonClick(view_icon_news)
//            Page.INFORMATION -> {
//                setButtonClick(view_icon_information)
//                bundle.putString(PAGE_TYPE, Constants.DataType.products.toString())
//            }
//            Page.TOPICS -> {
//                setButtonClick(view_icon_topic)
//                bundle.putString(PAGE_TYPE, Constants.DataType.goods.toString())
//            }
//            Page.LOCAL_FARMER -> {
//                setButtonClick(view_icon_local_farmer)
//                bundle.putString(PAGE_TYPE, Constants.DataType.local.toString())
//            }
//        }
//
//        switchPage(R.id.fragment_container, page, bundle, true, false)
//    }

}

