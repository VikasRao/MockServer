package com.test.mockserverespresso.storage

import android.app.Application
import android.content.Context
import javax.inject.Inject


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
class SPreference @Inject constructor(context: Application) {
    private val sharedPreferences = context.getSharedPreferences("MalichaPref", Context.MODE_PRIVATE)

    fun setName(access: String) {
        with(sharedPreferences.edit()) {
            putString("sdf", access);
            apply()
        }
    }


    fun getName(): String? {
        return sharedPreferences.getString("sdf", "")
    }
}