package com.gabrielfv.pay.home

import android.view.View
import androidx.core.view.isVisible
import com.gabrielfv.hyper.HyperView
import kotlinx.android.synthetic.main.home_view.view.*

class HomeView(
    override val controller: HomeController
) : HyperView.NoAction<HomeState> {
    private lateinit var view: View

    override fun initView(view: View) {
        this.view = view
        view.buttonAddMoney.setOnClickListener {
            controller.addMoney()
        }
    }

    override fun updateState(state: HomeState) {
        state.balance?.let { balance ->
            view.labelBalance.text = controller.getFormattedBalance(balance)
        }

        view.loading.isVisible = state.isLoading
        view.labelBalance.isVisible = !state.isLoading
    }
}