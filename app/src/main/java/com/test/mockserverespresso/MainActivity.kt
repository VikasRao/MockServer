package com.test.mockserverespresso

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.mockserverespresso.di.LoginComponent
import com.test.mockserverespresso.di.injectViewModel
import com.test.mockserverespresso.storage.SPreference
import com.test.mockserverespresso.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var loginViewModel: LoginViewModel
    lateinit var loginComponent: LoginComponent

    @Inject
    lateinit var sPreference:SPreference



    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent = (application as MockApp)
                .appComponent
                .loginComponent()
                .create()
        loginComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sPreference.getName()

        loginViewModel = injectViewModel(viewModelFactory)

        loginViewModel.response.observe(this, Observer {
            (text_result as TextView).text = it
        })

        button.setOnClickListener {
            loginViewModel.callAPi()
        }
    }
}