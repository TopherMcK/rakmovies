package com.learning.ramovies.login.di

import com.learning.ramovies.login.LoginViewModel
import com.learning.ramovies.util.LoginUtil
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(androidApplication(), LoginUtil()) }
}