package com.learning.ramovies.base.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.learning.ramovies.models.ombd.Movie
import com.learning.ramovies.models.ombd.search.SearchModel
import com.learning.ramovies.rest.SearchRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils
import retrofit2.Response
import timber.log.Timber

abstract class BaseSearchViewModel(application: Application, private val searchRepo: SearchRepo) : BaseViewModel(application) {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val searchLiveData = MutableLiveData<List<Movie>>()

    fun sendSearchRequest(searchQuery: String) {
        if(StringUtils.isNotBlank(searchQuery)) {
            compositeDisposable.add(searchRepo.getSearch(searchQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleSuccess, this::handleError))
        }
    }

    private fun handleSuccess(response: Response<SearchModel>) {
        if(response.code() == 200 && response.body() != null && CollectionUtils.isNotEmpty(response.body()?.Search)) {
            searchLiveData.postValue(response.body()!!.Search)
        } else {
            Timber.e("Error in Search Response : %s", response.errorBody());
        }
    }

    private fun handleError(throwable: Throwable) {
        Timber.e(throwable, "Search Error Occurred: %s", throwable.message)
    }

    fun searchLiveData(): MutableLiveData<List<Movie>> {
        return searchLiveData
    }

    override fun onCleared() {
        super.onCleared()
        this.compositeDisposable.clear()
    }
}