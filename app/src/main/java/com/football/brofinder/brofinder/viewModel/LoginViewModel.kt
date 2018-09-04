package com.football.brofinder.brofinder.viewModel

import android.arch.lifecycle.ViewModel
import com.football.brofinder.brofinder.data.network.ApiInterface
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val apiInstance by inject<ApiInterface>()
//
//    fun loginAction{
//
//        //apiIn
//    }

}