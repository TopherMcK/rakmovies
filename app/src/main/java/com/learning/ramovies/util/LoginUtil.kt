package com.learning.ramovies.util

class LoginUtil {
    fun hasValidUsername(username: String): Boolean {
        if(username.trim().length > 2) {
            return true
        }
        return false
    }

    fun hasValidPassword(password: String): Boolean {
        // we'll allow passwords to contain trailing or leading white spaces ;)
        if(password.length > 2) {
            return true
        }
        return false
    }
}