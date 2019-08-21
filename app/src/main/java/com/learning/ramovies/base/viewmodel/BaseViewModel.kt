package com.learning.ramovies.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.apache.commons.lang3.StringUtils

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private var username : String? = null

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    open fun getNavbarTitle(): String? {
        return null
    }

    open fun getMenuTitle(): String? {
        return null
    }
}