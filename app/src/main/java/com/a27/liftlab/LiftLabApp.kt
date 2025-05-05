package com.a27.liftlab

import android.app.Application
import com.a27.liftlab.di.appModule
import com.a27.liftlab.di.authModule
import com.a27.liftlab.di.dietModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LiftLabApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LiftLabApp)
            androidLogger()

            modules(appModule)
            modules(authModule)
            modules(dietModule)
        }
    }
}