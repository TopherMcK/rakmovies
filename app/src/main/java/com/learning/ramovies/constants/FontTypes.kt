package com.learning.ramovies.constants

enum class FontTypes constructor(private val path: String) {
    BLOCKBUSTER("fonts/blockbuster.ttf");

    fun getPath(): String {
        return path
    }
}