package com.gabrielfv.pay.cashin

import com.gabrielfv.hyper.HyperController
import com.gabrielfv.hyper.HyperState
import com.gabrielfv.hyper.HyperView
import kotlinx.android.parcel.Parcelize

class CashInController : HyperController.Static(R.layout.cash_in_view) {
    fun cashIn(value: Int) {

    }

    override val view: HyperView.Static = CashInView(this)
}

