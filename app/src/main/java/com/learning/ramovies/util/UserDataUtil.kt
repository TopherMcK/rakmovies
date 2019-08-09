package com.learning.ramovies.util

class UserDataUtil {
    fun getDisplayName(username: String?): String? {
        return if (username != null && username.length > 9) String.format("%s%s", username.substring(0, 9), "...") else username
    }
}