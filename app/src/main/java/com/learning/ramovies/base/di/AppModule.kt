package com.learning.ramovies.base.di

import android.content.Context
import android.graphics.Typeface
import com.learning.ramovies.constants.FontTypes
import com.learning.ramovies.util.CustomFontUtil
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { createCustomFontUtil(androidContext()) }
}

private fun createCustomFontUtil(context: Context): CustomFontUtil {
    val fonts = HashMap<FontTypes, Typeface>()
    fonts.put(FontTypes.BLOCKBUSTER, Typeface.createFromAsset(context.assets, FontTypes.BLOCKBUSTER.getPath()))

    return CustomFontUtil(fonts)
}