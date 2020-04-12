package com.test.mockserverespresso.di

import android.app.Application
import com.test.mockserverespresso.MockApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */

@Singleton
@Component(modules = [AppModule::class,RetrofitModule::class, AppSubComponent::class])
interface AppComponent {

    fun loginComponent(): LoginComponent.Factory

    fun inject(application: MockApp)


}