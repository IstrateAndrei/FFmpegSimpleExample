package com.football.brofinder.brofinder.koin

import com.football.brofinder.brofinder.data.network.ApiInterface
import com.football.brofinder.brofinder.viewModel.LoginViewModel
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

    private val retrofitModule: Module = applicationContext {
        bean {
            Retrofit.Builder()
                    .baseUrl("localhost/8080") // change this with actual api url
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(ApiInterface::class.java)
        }
        bean { ApiInterface::class }
    }

    private val loginModelModule: Module = applicationContext {
        viewModel { LoginViewModel() }
    }

    val modules = listOf(retrofitModule, loginModelModule);

}