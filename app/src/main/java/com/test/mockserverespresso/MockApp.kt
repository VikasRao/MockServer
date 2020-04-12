package com.test.mockserverespresso

import android.app.Application
import com.test.mockserverespresso.di.AppComponent
import com.test.mockserverespresso.di.AppModule
import com.test.mockserverespresso.di.DaggerAppComponent
import com.test.mockserverespresso.network.APiServices
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
open class MockApp : Application() {


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

       appComponent.inject(this)
    }


    open val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


}