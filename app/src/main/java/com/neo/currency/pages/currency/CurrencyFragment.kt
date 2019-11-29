package com.neo.currency.pages.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neo.currency.AppInjector
import com.neo.currency.R
import com.neo.currency.pages.base.InteractionView
import com.neo.currency.pages.base.OnPageInteractionListener

class CurrencyFragment : InteractionView<OnPageInteractionListener.Primary>() {

    private lateinit var mViewModel: CurrencyViewModel

    companion object {
        fun newInstance(): CurrencyFragment = CurrencyFragment()
        private val TAG = CurrencyFragment::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = AppInjector.obtainViewModel(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_curreny, container, false)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.getCurrencyList()
    }
}