package com.test.mockserverespresso

import android.app.Application
import android.content.Context
import com.test.mockserverespresso.di.AppModule
import com.test.mockserverespresso.di.ViewModelModule
import com.test.mockserverespresso.storage.SPreference
import dagger.Module
import dagger.Provides
import javax.annotation.Nonnull
import javax.inject.Singleton


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
@Module(includes = [ViewModelModule::class])
class MockAppModule(application: Application) : AppModule(application) {

    @Provides
    override fun provideApplication(): Application {
        return application
    }

    @Provides
    override fun provideContext(): Context {
        return application
    }
    //Preference
    @Singleton
    @Provides
    override fun provideStorage(context: Application): SPreference {
        return SPreference(context)
    }

}