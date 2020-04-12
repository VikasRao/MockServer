package com.test.mockserverespresso.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
data class Value(
        @field:SerializedName("x")
        val x: Int,
        @field:SerializedName("y")
       val y: Double)
