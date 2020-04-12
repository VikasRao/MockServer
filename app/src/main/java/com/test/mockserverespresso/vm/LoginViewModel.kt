package com.test.mockserverespresso.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.mockserverespresso.network.APiServices
import com.test.mockserverespresso.network.ChartsResponse
import com.test.mockserverespresso.storage.SPreference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
class LoginViewModel @Inject constructor(var sep: SPreference, var service: APiServices) : ViewModel() {


    private var _response: MutableLiveData<String> = MutableLiveData<String>()
    val response: LiveData<String> = _response

    fun callAPi() {
        viewModelScope.launch(Dispatchers.IO) {
            sep.getName()
            try {
                val response = service.getCharts()
                if (response.body() is ChartsResponse) {
                    _response.postValue("Success: ${(response.body())!!.title}")
                    Timber.d(">>>>>>${response.message()}")
                } else {
                    _response.postValue("Failed")
                    Timber.d(">>>>>>${response.errorBody().toString()}")
                }

            } catch (ex: Exception) {
                _response.postValue("Failed")
                Timber.e("${ex.message}")
            }
        }
    }
}