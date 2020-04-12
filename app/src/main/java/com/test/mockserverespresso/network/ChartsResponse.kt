package com.test.mockserverespresso.network

import com.google.gson.annotations.SerializedName


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
data class ChartsResponse(

        @field:SerializedName("userId")
        val userId: Int,
        @field:SerializedName("id")
        val id: Int,
        @field:SerializedName("title")
        val title: String,
        @field:SerializedName("completed")
        val completed: Boolean)



