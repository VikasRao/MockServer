package com.test.mockserverespresso.di

import android.app.Application
import com.readystatesoftware.chuck.ChuckInterceptor
import com.test.mockserverespresso.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
open class RetrofitModule {


    @Singleton
    @Provides
    open fun provideHttpClient(application: Application): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(application))
                .build()

    }

    @Singleton
    @Provides
    open fun createRetroFit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}