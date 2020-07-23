package com.gabrielfv.pay.home.domain

import com.gabrielfv.pay.data.access.UserDao
import javax.inject.Inject

class GetUserBalanceUseCase @Inject constructor(
    private val dao: UserDao
) {
    suspend fun execute(): Int {
        return dao.getAll().firstOrNull()?.balance ?: 0
    }
}