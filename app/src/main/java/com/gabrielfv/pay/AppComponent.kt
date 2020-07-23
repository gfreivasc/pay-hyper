package com.gabrielfv.pay

import android.content.Context
import com.gabrielfv.hyper_dagger.HyperControllerFactory
import com.gabrielfv.pay.data.DataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class
    ]
)
interface AppComponent {
    fun controllerFactory(): HyperControllerFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}