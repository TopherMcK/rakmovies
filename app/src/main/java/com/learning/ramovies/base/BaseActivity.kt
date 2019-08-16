package com.learning.ramovies.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.learning.ramovies.R
import com.learning.ramovies.login.LoginActivity
import com.learning.ramovies.main.MainActivity


abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }

    @LayoutRes
    protected abstract fun layoutRes():Int

    protected abstract fun currentActivity(): AppCompatActivity

    protected fun getActivityToStart(menuItemId: Int): Class<*>? {
        var classToStart: Class<*>? = null

        if(menuItemId == R.id.home && currentActivity() !is MainActivity) {
            classToStart = MainActivity::class.java
        } else if (menuItemId == R.id.return_to_login && currentActivity() !is LoginActivity) {
            classToStart = LoginActivity::class.java
        }

        return classToStart
    }

    protected fun launchNewActivity(@NonNull activityToStart: Class<*>) {
        val newActivity = Intent(this.currentActivity(), activityToStart)
        launchNewActivity(newActivity)
    }

    protected fun launchNewActivity(@NonNull newActivity: Intent) {
        this.startActivity(newActivity)
    }
}