package com.gabrielfv.pay.nav

import android.net.Uri
import androidx.annotation.IdRes
import androidx.navigation.navOptions

object Nav {
    private const val SCHEMA = "gfvPay://"
    val CASH_IN get() = "${SCHEMA}cashIn".toUri()

    fun buildNavOptions(
        singleTop: Boolean = false,
        @IdRes popUpTo: Int? = null
    ) = navOptions {
        launchSingleTop = singleTop
        popUpTo?.let { this.popUpTo = it }

        anim {
            enter = R.anim.nav_default_enter_anim
            popEnter = R.anim.nav_default_pop_enter_anim
            exit = R.anim.nav_default_exit_anim
            popExit = R.anim.nav_default_pop_exit_anim
        }
    }

    private fun String.toUri(): Uri = Uri.parse(this)
}