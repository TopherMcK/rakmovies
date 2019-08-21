package com.learning.ramovies.login

import android.app.Application
import com.learning.ramovies.base.viewmodel.BaseViewModel
import com.learning.ramovies.util.LoginUtil

class LoginViewModel(appContext: Application, private val loginUtil: LoginUtil) : BaseViewModel(appContext) {

    private var password: String? = null

    private var hasValidUsername = false
    private var hasValidPassword = false

    fun getPassword(): String? {
        return password
    }

    fun validateUsername(username: String) {
        if(loginUtil.hasValidUsername(username)) {
            hasValidUsername = true
            setUsername(username)
        } else {
            hasValidUsername = false
            setUsername(null)
        }
    }

    fun validatePassword(password: String) {
        if(loginUtil.hasValidUsername(password)) {
            hasValidPassword = true
            this.password = password
        } else {
            hasValidPassword = false
            this.password = null
        }
    }

    fun hasValidSubmission(): Boolean {
        return hasValidUsername && hasValidPassword
    }
}