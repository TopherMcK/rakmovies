package com.learning.ramovies.di

import com.learning.ramovies.util.UserDataUtil
import org.koin.dsl.module

val appModule = module {
    single { UserDataUtil() }
}