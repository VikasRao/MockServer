package com.test.mockserverespresso.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
interface APiServices {
    @GET("todos/1")
    suspend fun getCharts(): Response<ChartsResponse>
}