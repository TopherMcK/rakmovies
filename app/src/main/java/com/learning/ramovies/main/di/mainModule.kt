package com.learning.ramovies.main.di

import com.learning.ramovies.main.MainActivityViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainActivityViewModel(androidApplication()) }
}