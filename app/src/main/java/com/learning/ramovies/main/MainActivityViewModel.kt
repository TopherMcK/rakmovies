package com.learning.ramovies.main

import android.app.Application
import com.learning.ramovies.base.BaseViewModel
import com.learning.ramovies.util.UserDataUtil

class MainActivityViewModel(app : Application) : BaseViewModel(app) {
    override fun getNavbarTitle(): String? {
        return UserDataUtil.getDisplayName(getUsername())
    }
    override fun getMenuTitle(): String? {
        return UserDataUtil.getDisplayName(getUsername())
    }
}