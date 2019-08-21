package com.learning.ramovies.rest.di

import com.learning.ramovies.rest.SearchRepo
import com.learning.ramovies.util.RestConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val restModule = module {
    single { createSearchService() }
}

private fun createSearchService() : SearchRepo {
    return Retrofit.Builder().baseUrl(RestConstants.OMDB_URL).client(createOkHttpSearchInterceptor()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build().create(SearchRepo::class.java)
}

private fun createOkHttpSearchInterceptor(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
}