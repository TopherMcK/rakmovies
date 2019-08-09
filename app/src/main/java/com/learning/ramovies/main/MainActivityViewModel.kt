package com.learning.ramovies.main

import android.app.Application
import com.learning.ramovies.base.BaseViewModel
import com.learning.ramovies.util.UserDataUtil

class MainActivityViewModel(app : Application, private val userDataUtil: UserDataUtil) : BaseViewModel(app) {
    override fun getNavbarTitle(): String? {
        return userDataUtil.getDisplayName(getUsername())
    }
    override fun getMenuTitle(): String? {
        return userDataUtil.getDisplayName(getUsername())
    }
}