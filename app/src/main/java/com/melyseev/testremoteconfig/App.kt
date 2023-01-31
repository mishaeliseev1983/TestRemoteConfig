package com.melyseev.testremoteconfig

import android.app.Application
import com.melyseev.testremoteconfig.di.DaggerApplicationComponent

class App: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}