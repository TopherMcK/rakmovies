package com.learning.ramovies.main

import androidx.appcompat.app.AppCompatActivity
import com.learning.ramovies.R
import com.learning.ramovies.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

    override fun getHeaderTitle(): String? {
        return null
    }
}
