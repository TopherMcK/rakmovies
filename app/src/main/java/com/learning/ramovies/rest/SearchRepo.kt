package com.learning.ramovies.rest

import com.learning.ramovies.models.ombd.search.SearchModel
import com.learning.ramovies.util.RestConstants
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRepo {
    @GET("?type=movie&apikey=" + RestConstants.OMDB_API_KEY)
    fun getSearch(@Query(value = "s") query: String): Observable<Response<SearchModel>>
}