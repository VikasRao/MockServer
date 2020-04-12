package com.test.mockserverespresso.di

import com.test.mockserverespresso.network.APiServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */

@Module(subcomponents = [LoginComponent::class])
class AppSubComponent {

    @Provides
    fun providesSelfSignupservice(retrofit: Retrofit): APiServices {
        return retrofit.create(APiServices::class.java)
    }

}