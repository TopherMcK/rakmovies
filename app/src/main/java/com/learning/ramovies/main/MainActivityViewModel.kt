package com.learning.ramovies.main

import android.app.Application
import com.learning.ramovies.base.viewmodel.BaseSearchViewModel
import com.learning.ramovies.rest.SearchRepo
import com.learning.ramovies.util.UserDataUtil

class MainActivityViewModel(app : Application, searchRepo: SearchRepo) : BaseSearchViewModel(app, searchRepo) {
    override fun getNavbarTitle(): String? {
        return UserDataUtil.getDisplayName(getUsername())
    }
    override fun getMenuTitle(): String? {
        return UserDataUtil.getDisplayName(getUsername())
    }
}