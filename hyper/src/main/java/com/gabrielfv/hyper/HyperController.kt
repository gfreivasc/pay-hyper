package com.gabrielfv.hyper

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.gabrielfv.hyper.internal.CloseableCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

private const val STATE_REGISTRY = "hyper_state_registry"

abstract class HyperController<State : HyperState, Action : Any>(
    @LayoutRes val contentLayoutId: Int
) : Fragment(contentLayoutId) {
    abstract val view: HyperView<State, Action>
    private lateinit var state: State
    protected val coroutineScope: CoroutineScope by lazy {
        CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    }

    abstract fun initState(): State

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view.initView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val registry = savedInstanceState?.get(STATE_REGISTRY) as? State
        state = registry ?: initState()
        view.updateState(state)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    fun updateState(updater: (State) -> State) {
        state = updater(state)
        view.updateState(state)
    }

    fun sendAction(action: Action) {
        view.sendAction(action)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(STATE_REGISTRY, state)
        super.onSaveInstanceState(outState)
    }

    abstract class NoAction<S : HyperState>(
        @LayoutRes layoutId: Int
    ) : HyperController<S, Nothing>(layoutId)

    abstract class Stateless<A : Any>(
        @LayoutRes layoutId: Int
    ) : HyperController<HyperState.None, A>(layoutId) {
        override fun initState() = HyperState.None
    }

    abstract class Static(
        @LayoutRes layoutId: Int
    ) : HyperController.Stateless<Nothing>(layoutId)
}