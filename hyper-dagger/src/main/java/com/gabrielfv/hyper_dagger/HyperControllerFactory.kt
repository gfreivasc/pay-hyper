package com.gabrielfv.hyper_dagger

import androidx.collection.SimpleArrayMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.gabrielfv.hyper.HyperController
import javax.inject.Provider

typealias HyperProviderMap =
    Map<Class<out Fragment>, @JvmSuppressWildcards Provider<HyperController<*, *>>>

class HyperControllerFactory(
    private val controllerProviders: HyperProviderMap
) : FragmentFactory() {
    private val cachedClasses = SimpleArrayMap<String, Class<out Fragment>>()

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val clazz = cachedClasses[className] ?: run {
            Class.forName(className).also { clazz ->
                val cached = clazz as? Class<out Fragment>
                cached?.let { cachedClasses.put(className, it) }
            }
        }
        return controllerProviders[clazz]?.get() ?: super.instantiate(classLoader, className)
    }
}