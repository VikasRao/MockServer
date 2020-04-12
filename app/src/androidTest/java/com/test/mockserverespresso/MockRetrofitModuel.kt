package com.test.mockserverespresso

import android.app.Application
import com.readystatesoftware.chuck.ChuckInterceptor
import com.test.mockserverespresso.di.RetrofitModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Vikas Rao on 30,March,2020
 *
 */
@Module
class MockRetrofitModuel:RetrofitModule() {

    /*@Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient?): Retrofit? {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("http://localhost:8080/")
                .build()
    }*/

    @Singleton
    @Provides
    override fun provideHttpClient(application: Application): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(application))
                .build()

    }

    @Singleton
    @Provides
    override fun createRetroFit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}