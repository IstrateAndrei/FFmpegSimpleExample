package com.football.brofinder.brofinder

import android.app.Application
import com.football.brofinder.brofinder.koin.AppModules
import org.koin.android.ext.android.releaseProperties
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.android.startKoin

class BroApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, AppModules.modules)
        setProperty("application-context", applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        releaseProperties("application-context")
    }
}