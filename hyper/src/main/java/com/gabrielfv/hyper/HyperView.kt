package com.gabrielfv.hyper

import android.view.View

interface HyperView<State : HyperState, Action : Any> {
    val controller: HyperController<State, Action>

    fun initView(view: View)

    fun updateState(state: State)
    fun sendAction(action: Action)

    interface NoAction<State : HyperState> : HyperView<State, Nothing> {
        override fun sendAction(action: Nothing) = Unit
    }

    interface Stateless<Action : Any> : HyperView<HyperState.None, Action> {
        override fun updateState(state: HyperState.None) = Unit
    }

    interface Static : Stateless<Nothing> {
        override fun sendAction(action: Nothing) = Unit
    }
}