package com.gabrielfv.pay.cashin

import androidx.navigation.fragment.findNavController
import com.gabrielfv.hyper.HyperController
import com.gabrielfv.hyper.HyperState
import com.gabrielfv.hyper.HyperView
import com.gabrielfv.pay.cashin.domain.AddBalanceUseCase
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.launch
import javax.inject.Inject

class CashInController @Inject constructor(
    private val addBalanceUseCase: AddBalanceUseCase
) : HyperController.Static(R.layout.cash_in_view) {
    fun cashIn(value: Int) {
        coroutineScope.launch {
            addBalanceUseCase.execute(value)
            findNavController().popBackStack()
        }
    }

    override val view: HyperView.Static = CashInView(this)
}

