package com.gabrielfv.pay.home

import androidx.navigation.fragment.findNavController
import com.gabrielfv.hyper.HyperController
import com.gabrielfv.hyper.HyperState
import com.gabrielfv.hyper.HyperView
import com.gabrielfv.pay.home.domain.GetUserBalanceUseCase
import com.gabrielfv.pay.nav.Nav
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeController @Inject constructor(
    private val getUserBalanceUseCase: GetUserBalanceUseCase
) : HyperController.NoAction<HomeState>(R.layout.home_view) {
    override val view: HyperView.NoAction<HomeState> = HomeView(this)

    override fun initState(): HomeState = HomeState(true, null).also {
        fetchBalance()
    }

    fun addMoney() {
        findNavController().navigate(Nav.CASH_IN, Nav.buildNavOptions())
    }

    fun getFormattedBalance(balance: Int): String {
        return getString(R.string.balance_format, parseBalanceText(balance))
    }

    private fun fetchBalance() {
        coroutineScope.launch {
            val balance = getUserBalanceUseCase.execute()
            updateState { HomeState(false, balance) }
        }
    }

    private fun parseBalanceText(value: Int): String {
        return "R$ %d,%02d".format(value / 100, value % 100)
    }
}

@Parcelize
data class HomeState(
    val isLoading: Boolean,
    val balance: Int?
) : HyperState