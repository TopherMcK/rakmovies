package com.learning.ramovies.util

import android.graphics.Typeface
import android.widget.Button
import android.widget.TextView
import com.learning.ramovies.constants.FontTypes

class CustomFontUtil(private val fonts: Map<FontTypes, Typeface>) {

    fun setToBlockbusterFont(textView: TextView) {
        textView.typeface = fonts.get(FontTypes.BLOCKBUSTER)
    }

    fun setToBlockbusterFont(button: Button) {
        button.typeface = fonts.get(FontTypes.BLOCKBUSTER)
    }
}