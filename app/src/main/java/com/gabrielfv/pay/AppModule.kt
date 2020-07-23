package com.gabrielfv.pay

import com.gabrielfv.hyper.HyperController
import com.gabrielfv.hyper_dagger.HyperControllerFactory
import com.gabrielfv.hyper_dagger.HyperProviderMap
import com.gabrielfv.pay.home.HomeController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Singleton

@Module
interface AppModule {
    @Binds
    @IntoMap
    @StringKey("com.gabrielfv.pay.home.HomeController")
    fun bindHomeController(controller: HomeController): HyperController<*, *>

    companion object {
        @Singleton
        @Provides
        fun providesControllerFactory(providerMap: HyperProviderMap) =
            HyperControllerFactory(providerMap)
    }
}