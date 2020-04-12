package com.test.mockserverespresso.di

import com.test.mockserverespresso.MainActivity
import dagger.Subcomponent


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
@ActivityScope
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): LoginComponent
    }


    fun inject (activity: MainActivity)
}