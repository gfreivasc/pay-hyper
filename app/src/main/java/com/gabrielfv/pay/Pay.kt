package com.gabrielfv.pay

import android.app.Application

class Pay : Application() {
    lateinit var daggerComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerAppComponent.factory()
            .create(this)
    }
}