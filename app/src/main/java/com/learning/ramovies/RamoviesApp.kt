package com.learning.ramovies

import android.app.Application
import android.content.Context
import com.learning.ramovies.di.appModule
import com.learning.ramovies.login.di.loginModule
import com.learning.ramovies.main.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RamoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Need to check for robolectric
        if(GlobalContext.getOrNull() == null) {
            val appContext: Context = this

            startKoin {
                modules(
                    listOf(
                        loginModule,
                        mainModule,
                        appModule
                    )
                ).androidContext(appContext)
            }

        }
        Timber.plant(Timber.DebugTree())
    }
}