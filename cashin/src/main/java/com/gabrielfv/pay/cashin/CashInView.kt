package com.gabrielfv.pay.cashin

import android.view.View
import com.gabrielfv.hyper.HyperState
import com.gabrielfv.hyper.HyperView
import kotlinx.android.synthetic.main.cash_in_view.view.*

class CashInView(
    override val controller: CashInController
) : HyperView.Static {

    override fun initView(view: View) {
        with (view) {
            buttonCashIn.setOnClickListener {
                val value = inputValue.text.toString().toInt()
                controller.cashIn(value)
            }
        }
    }
}