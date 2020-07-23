package com.gabrielfv.pay

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class HostActivity : FragmentActivity(R.layout.host_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = (application as Pay)
            .daggerComponent
            .controllerFactory()
        super.onCreate(savedInstanceState)
    }
}