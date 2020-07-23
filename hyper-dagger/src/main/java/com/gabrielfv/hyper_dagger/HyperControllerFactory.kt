package com.gabrielfv.hyper_dagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.gabrielfv.hyper.HyperController
import javax.inject.Provider

typealias HyperProviderMap =
    Map<String, @JvmSuppressWildcards Provider<HyperController<*, *>>>

class HyperControllerFactory(
    private val controllerProviders: HyperProviderMap
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return controllerProviders[className]?.get() ?: super.instantiate(classLoader, className)
    }
}