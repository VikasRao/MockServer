package com.test.mockserverespresso.di

import android.app.Application
import android.content.Context
import com.test.mockserverespresso.storage.SPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
@Module(includes = [ViewModelModule::class])
open class AppModule(val application: Application) {


    @Provides
    open fun provideApplication(): Application {
        return application
    }

    @Provides
    open fun provideContext(): Context {
        return application
    }
    //Preference
    @Singleton
    @Provides
    open fun provideStorage(context: Application): SPreference {
        return SPreference(context)
    }


}