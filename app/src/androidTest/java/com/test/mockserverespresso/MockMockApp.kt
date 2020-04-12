package com.test.mockserverespresso

import com.test.mockserverespresso.di.AppComponent
import com.test.mockserverespresso.di.AppSubComponent
import com.test.mockserverespresso.di.DaggerAppComponent
import timber.log.Timber


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
class MockMockApp : MockApp() {

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        // database.getName()
    }


    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(MockAppModule(this))
                .retrofitModule(MockRetrofitModuel()).build()
    }

}