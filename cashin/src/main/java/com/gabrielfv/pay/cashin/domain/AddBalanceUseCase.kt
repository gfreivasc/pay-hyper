package com.gabrielfv.pay.cashin.domain

import com.gabrielfv.pay.data.access.UserDao
import com.gabrielfv.pay.data.entities.User
import javax.inject.Inject

private const val MULTIPLIER = 100

class AddBalanceUseCase @Inject constructor(
    private val dao: UserDao
) {

    suspend fun execute(value: Int) {
        val realValue = value * MULTIPLIER
        val entry = dao.getAll().firstOrNull()
        if (entry != null) {
            dao.updateUserBalance(
                entry.uuid,
                entry.balance + realValue
            )
        } else {
            dao.insertAll(User(balance = realValue))
        }
    }
}