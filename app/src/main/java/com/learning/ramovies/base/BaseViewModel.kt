package com.learning.ramovies.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private var username : String? = null

    private var isGuest = true

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun isGuest(): Boolean {
        return isGuest
    }

    fun setIsGuest(isGuest: Boolean) {
        this.isGuest = isGuest
    }

    open fun getNavbarTitle(): String? {
        return null
    }

    open fun getMenuTitle(): String? {
        return null
    }
}