package com.learning.ramovies.rest

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageRetrievalRepo {
    @GET
    fun retrieveImage(@Url url: String): Observable<ResponseBody>
}