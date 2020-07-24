package com.gabrielfv.pay

import com.gabrielfv.hyper.HyperController
import com.gabrielfv.hyper_dagger.HyperControllerFactory
import com.gabrielfv.hyper_dagger.HyperControllerKey
import com.gabrielfv.hyper_dagger.HyperProviderMap
import com.gabrielfv.pay.cashin.CashInController
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
    @HyperControllerKey(HomeController::class)
    fun bindHomeController(controller: HomeController): HyperController<*, *>

    @Binds
    @IntoMap
    @HyperControllerKey(CashInController::class)
    fun bindCashInController(controller: CashInController): HyperController<*, *>

    companion object {
        @Singleton
        @Provides
        fun providesControllerFactory(providerMap: HyperProviderMap) =
            HyperControllerFactory(providerMap)
    }
}